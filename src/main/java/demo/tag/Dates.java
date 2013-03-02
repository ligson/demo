package demo.tag;

import java.io.IOException;
import java.io.Writer;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.struts2.components.Component;

import com.opensymphony.xwork2.util.ValueStack;

public class Dates extends Component {

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

	public Dates(ValueStack stack) {
		super(stack);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean start(Writer writer) {
		// TODO Auto-generated method stub
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(dateStringFormat);
			Date date = sdf.parse(dateString);
			sdf.applyPattern(dateParseFormat);
			String result = sdf.format(date);
			writer.write(result);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}

}
