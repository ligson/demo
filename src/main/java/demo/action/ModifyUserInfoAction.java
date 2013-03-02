package demo.action;

import com.opensymphony.xwork2.ActionSupport;

import demo.domain.User;
import demo.service.UserService;

public class ModifyUserInfoAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private User user;
	private UserService userService;

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		userService.modify(user);
		return SUCCESS;
	}

}
