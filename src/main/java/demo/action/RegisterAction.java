package demo.action;

import org.apache.commons.lang3.StringUtils;

import com.opensymphony.xwork2.ActionSupport;

import demo.domain.User;
import demo.service.UserService;

public class RegisterAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2631208834508170834L;

	private User user;
	private UserService userService;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@Override
	public void validate() {
		System.out.println("11111111111111111111");
		if (!StringUtils.isNotBlank(user.getName())) {
			addFieldError("user.name", "name is required");
		}
		if (!StringUtils.isNotBlank(user.getPassword())) {
			addFieldError("user.password", "password is required");
		}
		if (StringUtils.isNotBlank(user.getEmail())) {
			if (!user.getEmail().matches(
					"^[a-zA-Z0-9_\\.]+@[a-zA-Z0-9-]+[\\.a-zA-Z]+$")) {
				addFieldError("user.email", "email format error");
			}
		}
	}

	@Override
	public String execute() throws Exception {
		System.out.println("dddddddddddddddddddddd");
		String id = userService.register(getUser());
		if (id == null) {
			return ERROR;
		} else {
			return INPUT;
		}
	}

}
