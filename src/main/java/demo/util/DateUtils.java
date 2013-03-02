package demo.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
	public static String dateToDbFormat(Date date) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		return dateFormat.format(date);
	}

	public static String dateTextToFormat(String text, String format1,
			String format2) {
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
			Date date = dateFormat.parse(text);
			dateFormat.applyPattern(format2);
			return dateFormat.format(date);
		} catch (Exception e) {
			return null;
		}
	}
}
