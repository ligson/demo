package demo.action;

import org.apache.commons.lang3.StringUtils;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import demo.service.UserService;

public class LoginAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 253057976256457595L;
	private String name;
	private String password;
	private UserService userService;

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
		if (getName() == null) {
			return LOGIN;
		} else {
			if (userService.login(getName(), getPassword())) {
				ActionContext
						.getContext()
						.getSession()
						.put("currentUser",
								userService.getUserByNameAndPassword(getName(),
										getPassword()));
				return SUCCESS;
			} else {
				return LOGIN;
			}
		}
	}

}
