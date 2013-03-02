package demo.tag;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.components.Component;
import org.apache.struts2.views.jsp.ComponentTagSupport;

import com.opensymphony.xwork2.util.ValueStack;

public class DateTag extends ComponentTagSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2642395986045853297L;
	private String dateString;
	private String dateStringFormat;
	private String dateParseFormat;

	public String getDateString() {
		return dateString;
	}

	public void setDateString(String dateString) {
		this.dateString = dateString;
	}

	public String getDateStringFormat() {
		return dateStringFormat;
	}

	public void setDateStringFormat(String dateStringFormat) {
		this.dateStringFormat = dateStringFormat;
	}

	public String getDateParseFormat() {
		return dateParseFormat;
	}

	public void setDateParseFormat(String dateParseFormat) {
		this.dateParseFormat = dateParseFormat;
	}

	@Override
	public Component getBean(ValueStack valueStack, HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		return new Dates(valueStack);
	}

	@Override
	protected void populateParams() {
		// TODO Auto-generated method stub
		super.populateParams();
		Dates dates = (Dates) component;
		dates.setDateString(dateString);
		dates.setDateStringFormat(dateStringFormat);
		dates.setDateParseFormat(dateParseFormat);
	}

}
