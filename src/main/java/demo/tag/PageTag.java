package demo.tag;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.components.Component;
import org.apache.struts2.views.jsp.ComponentTagSupport;

import com.opensymphony.xwork2.util.ValueStack;

public class PageTag extends ComponentTagSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5459683482264736816L;
	private int offset = 0;
	private int max = 10;
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

	@Override
	public Component getBean(ValueStack valueStack, HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		return new Pages(valueStack);
	}

	@Override
	protected void populateParams() {
		// TODO Auto-generated method stub
		super.populateParams();
		Pages pages = (Pages) component;
		pages.setMax(max);
		pages.setOffset(offset);
		pages.setTotal(total);
		pages.setUrl(url);
	}

}
