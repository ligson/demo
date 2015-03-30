package demo.search.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.response.FacetField;
import org.apache.solr.client.solrj.response.QueryResponse;

import demo.search.models.WebPage;
import demo.search.service.SearchService;

public class SearchServiceImpl implements SearchService {
	private HttpSolrServer solrServer;
	private String solrUrl;

	public void init() {
		solrServer = new HttpSolrServer(getSolrUrl());
		solrServer.setSoTimeout(3000); // socket read timeout
		solrServer.setConnectionTimeout(1000);
		solrServer.setDefaultMaxConnectionsPerHost(1000);
		solrServer.setMaxTotalConnections(10);
		solrServer.setFollowRedirects(false); // defaults to false
		solrServer.setAllowCompression(true);
		solrServer.setMaxRetries(1);
	}

	public HttpSolrServer getSolrServer() {
		return solrServer;
	}

	public void setSolrServer(HttpSolrServer solrServer) {
		this.solrServer = solrServer;
	}

	public String getSolrUrl() {
		return solrUrl;
	}

	public void setSolrUrl(String solrUrl) {
		this.solrUrl = solrUrl;
	}

	@Override
	public Map<String, Object> searchByTitleOrContent(String key, int offset,
			int max, String sort, boolean isAsc) {
		List<String> field = new ArrayList<String>();
		field.add("title");
		field.add("content");
		List<String> keyList = new ArrayList<>();
		keyList.add(key);
		keyList.add(key);
		List<String> sortfield = new ArrayList<String>();
		sortfield.add(sort);
		List<Boolean> flag = new ArrayList<>();
		flag.add(isAsc);
		return searchQuery(field, keyList, offset, max, sortfield, flag, true);
	}

	public QueryResponse search(List<String> field, List<String> key,
			int start, int count, List<String> sortfield, List<Boolean> flag,
			boolean hightlight) {
		// 检测输入是否合法
		if (null == field || null == key || field.size() != key.size()) {
			return null;
		}
		if (null == sortfield || null == flag
				|| sortfield.size() != flag.size()) {
			return null;
		}

		SolrQuery query = null;
		try {
			String params = "";
			for (int i = 0; i < field.size(); i++) {
				// query.addFilterQuery();
				if (i == field.size() - 1) {
					params += field.get(i) + ":" + key.get(i);
				} else {
					params += field.get(i) + ":" + key.get(i) + " OR ";
				}

			}
			// 初始化查询对象
			query = new SolrQuery(params);

			// 设置起始位置与返回结果数
			query.setStart(start);
			query.setRows(count);
			// 设置排序
			for (int i = 0; i < sortfield.size(); i++) {
				if (flag.get(i)) {
					SolrQuery.SortClause sortClause = new SolrQuery.SortClause(
							sortfield.get(i), SolrQuery.ORDER.asc);
					query.addSort(sortClause);
				} else {
					SolrQuery.SortClause sortClause = new SolrQuery.SortClause(
							sortfield.get(i), SolrQuery.ORDER.desc);
					query.addSort(sortClause);
				}
			}
			// 设置高亮
			if (hightlight) {
				query.setHighlight(true); // 开启高亮组件
				query.addHighlightField("title");// 高亮字段
				query.addHighlightField("content");// 高亮字段
				query.setHighlightSimplePre("<font color=\"red\">");// 标记
				query.setHighlightSimplePost("</font>");
				query.setHighlightSnippets(1);// 结果分片数，默认为1
				query.setHighlightFragsize(300);// 每个分片的最大长度，默认为100
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		QueryResponse rsp = null;
		try {
			rsp = solrServer.query(query);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		// 返回查询结果
		return rsp;
	}

	public Map<String, Object> searchQuery(List<String> field,
			List<String> key, int start, int count, List<String> sortfield,
			List<Boolean> flag, boolean hightlight) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<WebPage> modelList = new ArrayList<WebPage>();
		QueryResponse response = search(field, key, start, count, sortfield,
				flag, hightlight);
		map.put("total", 0);
		if (response != null) {
			long total = response.getResults().getNumFound();
			modelList = response.getBeans(WebPage.class);
			System.out.println(modelList.size());
			map.put("total", total);
			map.put("useTime", response.getElapsedTime() / 1000.00);
			Map<String, Map<String, List<String>>> hightlight2 = response
					.getHighlighting();
			List<Integer> removeSerialIndexList = new ArrayList<Integer>();
			for (int i = 0; i < modelList.size(); i++) {
				WebPage serialModel = modelList.get(i);
				// hightlight的键为Item的id，值唯一，我们设置的高亮字段为title
				if (hightlight2 != null && hightlight2.size() > 0) {
					Map<String, List<String>> contentValue = hightlight2
							.get(serialModel.getId());
					if ((contentValue != null) && (contentValue.size() > 0)) {
						List<String> matchValue = contentValue.get("title");
						int containCount = 0;
						if (matchValue != null) {
							if (matchValue.get(0) != null) {
								serialModel.setTitle(matchValue.get(0));
								containCount++;
							}
						}

						matchValue = contentValue.get("content");
						if (matchValue != null) {
							if (matchValue.get(0) != null) {
								serialModel.setContent(matchValue.get(0));
								containCount++;
							}
						}

						if (containCount == 0) {
							removeSerialIndexList.add(i);
						}

					} else {
						removeSerialIndexList.add(i);
					}

				}
			}
			int offset = 0;
			for (Integer index : removeSerialIndexList) {
				index = index - offset;
				modelList.remove(index);
				offset++;
			}
		}
		map.put("result", modelList);
		map.put("useTime",
				map.get("useTime") != null ? Double.parseDouble(map.get(
						"useTime").toString()) : 0);

		return map;
	}

	public String[] suggest(String prefix, int min) {
		String[] words = null;
		StringBuffer sb = new StringBuffer("");
		SolrQuery query = new SolrQuery("*.*");
		QueryResponse rsp = new QueryResponse();
		// Facet为solr中的层次分类查询
		try {
			query.setFacet(true);
			query.setQuery("*:*");
			query.setFacetPrefix(prefix);
			query.addFacetField("title");
			rsp = solrServer.query(query);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}

		if (null != rsp) {
			FacetField ff = rsp.getFacetField("title");
			List<FacetField.Count> countList = ff.getValues();
			if (null == countList) {
				return null;
			}
			for (int i = 0; i < countList.size(); i++) {
				String[] tmp = countList.get(i).toString().split(" ");
				// 排除单个字
				if (tmp[0].length() < 2) {
					continue;
				}
				sb.append(tmp[0] + " ");
				min--;
				if (min == 0) {
					break;
				}
			}
			words = sb.toString().split(" ");
		} else {
			return null;
		}
		return words;
	}

}
