package demo.search.action;

import java.io.UnsupportedEncodingException;
import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;

import demo.search.service.SearchService;

public class SearchAction extends ActionSupport {
	private SearchService searchService;
	private String key;
	private int offset;
	private int max;
	private String sort;
	private boolean isAsc;
	private Map<String, Object> result;

	public Map<String, Object> getResult() {
		return result;
	}

	public void setResult(Map<String, Object> result) {
		this.result = result;
	}

	public int getOffset() {
		return offset;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}

	public int getMax() {
		return max;
	}

	public void setMax(int max) {
		this.max = max;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public boolean isAsc() {
		return isAsc;
	}

	public void setAsc(boolean isAsc) {
		this.isAsc = isAsc;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public SearchService getSearchService() {
		return searchService;
	}

	public void setSearchService(SearchService searchService) {
		this.searchService = searchService;
	}

	public String index() {
		return SUCCESS;
	}

	public String search() {
		if (sort == null) {
			sort = "date";
		}
		if(max==0){
			max=20;
		}
		String keyString = getKey()+"";
		
		try {
			keyString = new String(keyString.getBytes("ISO-8859-1"),"UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		keyString = keyString.trim();
		setKey(keyString);
		System.out.println(getKey());
		result = searchService.searchByTitleOrContent(getKey(), offset, max,
				sort, isAsc);
		return SUCCESS;
	}
}
