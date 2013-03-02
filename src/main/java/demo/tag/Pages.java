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

		if (currentPage > 1) {
			sb.append("<h1><a href=\"" + url + "?offset="
					+ (currentPage - 1 - 1) * max + "&max=" + max
					+ "\">上一页</a></h1>");
		}
		if (currentPage < 10) {
			for (int i = 0; i < 10; i++) {
				if (i + 1 != currentPage) {
					sb.append("<a href=\"" + url + "?offset=" + i * max
							+ "&max=" + max + "\">" + (i + 1) + "</a>");
				} else {
					sb.append("<span>" + (i + 1) + "</span>");
				}
			}
		} else {
			if (totalPages - currentPage < 10) {
				for (int i = totalPages - 10 - 1; i < totalPages; i++) {
					if (i + 1 != currentPage) {
						sb.append("<a href=\"" + url + "?offset=" + i * max
								+ "&max=" + max + "\">" + (i + 1) + "</a>");
					} else {
						sb.append("<span>" + (i + 1) + "</span>");
					}
				}
			} else {
				for (int i = currentPage - 5; i < currentPage + 5; i++) {
					if (i + 1 != currentPage) {
						sb.append("<a href=\"" + url + "?offset=" + i * max
								+ "&max=" + max + "\">" + (i + 1) + "</a>");
					} else {
						sb.append("<span>" + (i + 1) + "</span>");
					}
				}
			}

		}
		if (currentPage < totalPages) {
			sb.append("<h1><a href=\"" + url + "?offset="
					+ (currentPage - 1 + 1) * max + "&max=" + max
					+ "\">下一页</a></h1>");
		}
		try {
			writer.write(sb.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}

}
