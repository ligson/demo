package demo.util;

import javax.servlet.http.HttpServletRequest;

public class ActionUtils {
	public static boolean isHttpClient(HttpServletRequest request){
		//user-agent:Apache-HttpClient/UNAVAILABLE (java 1.4)
		String value = request.getHeader("user-agent");
		return value.contains("HttpClient");
	}
}
