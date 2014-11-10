package demo.tag;

import java.io.IOException;
import java.io.Writer;

import org.apache.struts2.components.Component;

import com.opensymphony.xwork2.util.ValueStack;

public class Pages extends Component {

	private int offset;
	private int max;
	private int total;
	private String url;
	private String params;

	public String getParams() {
		return params;
	}

	public void setParams(String params) {
		this.params = params;
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

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Pages(ValueStack stack) {
		super(stack);
	}

	public static int getCurrentPages(int offset, int max) {
		return offset / max + 1;
	}

	public static int getTotalPages(int total, int max) {
		if (total % max > 0) {
			return total / max + 1;
		} else {
			return total / max;
		}
	}

	@Override
	public boolean start(Writer writer) {
		boolean result = super.start(writer);
		StringBuffer sb = new StringBuffer();
		int totalPages = getTotalPages(total, max);
		int currentPage = getCurrentPages(offset, max);

		int prevPageNum = currentPage - 1;
		int nextPageNum = currentPage + 1;

		if (prevPageNum >= 1) {
			if (getParams() != null) {
				sb.append("<h1><a href=\"" + url + "?offset="
						+ (currentPage - 1 - 1) * max + "&max=" + max + "&"
						+ params + "\">上一页</a></h1>");
			} else {
				sb.append("<h1><a href=\"" + url + "?offset="
						+ (currentPage - 1 - 1) * max + "&max=" + max
						+ "\">上一页</a></h1>");
			}

		}

		int startPageNum;
		int endPageNum;

		if (totalPages <= 11 && currentPage <= 11) {
			startPageNum = 1;
			endPageNum = totalPages;
		} else {
			startPageNum = currentPage - 5;
			if (startPageNum < 1) {
				startPageNum = 1;
			}
			endPageNum = startPageNum + 10;
			if (endPageNum > totalPages) {
				endPageNum = totalPages;
			}
			if (totalPages > 11 && endPageNum <= 11) {
				endPageNum = 11;
			}
		}

		for (int i = startPageNum; i <= endPageNum; i++) {
			if (i != currentPage) {
				if (getParams() != null) {
					sb.append("<a href=\"" + url + "?offset=" + (i - 1) * max
							+ "&max=" + max + "&" + params + "\">" + i + "</a>");
				} else {
					sb.append("<a href=\"" + url + "?offset=" + (i - 1) * max
							+ "&max=" + max + "\">" + i + "</a>");
				}

			} else {
				sb.append("<span>" + i + "</span>");
			}
		}

		if (nextPageNum < totalPages) {
			if (getParams() != null) {
				sb.append("<h1><a href=\"" + url + "?offset=" + currentPage
						* max + "&max=" + max + "&" + params
						+ "\">下一页</a></h1>");
			} else {
				sb.append("<h1><a href=\"" + url + "?offset=" + currentPage
						* max + "&max=" + max + "\">下一页</a></h1>");
			}

		}

		try {
			writer.write(sb.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}

}
