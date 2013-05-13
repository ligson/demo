package demo.action;

import java.util.Enumeration; 
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.components.ActionError;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import demo.domain.User;
import demo.service.UserService;
import demo.util.ActionUtils;

public class LoginAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 253057976256457595L;
	private String name;
	private String password;
	private UserService userService;
	private Map<String, Object> result = new HashMap<String, Object>();

	public Map<String, Object> getResult() {
		return result;
	}

	public void setResult(Map<String, Object> result) {
		this.result = result;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public void validate() {
		// TODO Auto-generated method stub
		if (!StringUtils.isNotBlank(getName())) {
			addFieldError("name", "name is not allow empty!");
		}
		if (!StringUtils.isNotBlank(getPassword())) {
			addFieldError("password", "password is not allow empty!");
		}
	}

	@Override
	public String execute() throws Exception {
		//System.out.println("JSESSIONID:"+ServletActionContext.getRequest().getCookies()[0].getValue());
		if (getName() == null) {
			return LOGIN;
		} else {
			boolean isSuccess = userService.login(getName(), getPassword());
			
			if (isSuccess) {
				User currentUser = userService.getUserByNameAndPassword(getName(),
						getPassword()); 
				ActionContext
						.getContext()
						.getSession()
						.put("currentUser",
								currentUser);
				ServletActionContext.getRequest().getSession().setAttribute("currentUser", currentUser);
				
				boolean isClient = ActionUtils.isHttpClient();
				if (isClient) {
					result.put("success", isSuccess);
					return "JSON_SUCCESS";
				}else{
					return SUCCESS;
				}
			} else {
				addActionError("用户名不存在或者密码错误！");
				return LOGIN;
			}
		}
	}

}
