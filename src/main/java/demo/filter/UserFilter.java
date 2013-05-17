package demo.filter;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class UserFilter extends AbstractInterceptor {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5571546773032533936L;

	private static Log log = LogFactory.getLog(UserFilter.class);

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		Map<String, Object> session = invocation.getInvocationContext()
				.getSession();
		HttpServletRequest request = ServletActionContext.getRequest();

		String uri = request.getRequestURL().toString();
		log.debug("JSESSIONID:" + request.getCookies()[0].getValue());
		log.debug("正在访问地址：" + uri);

		Object currentUser = session.get("currentUser");
		if (currentUser == null) {
			System.out.println("用户未登录");
			return Action.LOGIN;
		} else {
			return invocation.invoke();
		}
	}

}
