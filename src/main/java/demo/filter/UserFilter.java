package demo.filter;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class UserFilter extends AbstractInterceptor {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5571546773032533936L;

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		Map<String, Object> session = invocation.getInvocationContext()
				.getSession();
		HttpServletRequest request = ServletActionContext.getRequest();
		
		String uri = request.getRequestURL().toString();
		System.out.println("JSESSIONID:"+request.getCookies()[0].getValue());
		System.out.println("正在访问地址：" + uri);

		Object currentUser = session.get("currentUser");
		if (currentUser == null) {
			System.out.println("用户未登录");
			return Action.LOGIN;
		} else {
			return invocation.invoke();
		}
	}

}
