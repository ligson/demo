package demo.util;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

public class ActionUtils {
	public static boolean isHttpClient(){
		//user-agent:Apache-HttpClient/UNAVAILABLE (java 1.4)
		HttpServletRequest request = ServletActionContext.getRequest();
		String value = request.getHeader("user-agent");
		return value.contains("HttpClient");
	}
}
