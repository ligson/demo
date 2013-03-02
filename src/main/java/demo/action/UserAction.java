package demo.action;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import demo.domain.User;
import demo.service.UserService;

public class UserAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private UserService userService;
	private int max = 10;
	private int offset = 0;
	private List<User> users = new ArrayList<User>();
	private long total;
	private String uid;
	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public int getMax() {
		return max;
	}

	public void setMax(int max) {
		this.max = max;
	}

	public int getOffset() {
		return offset;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	@Override
	public String execute() throws Exception {
		return SUCCESS;
	}

	public String list() {
		users = userService.list(offset, max);
		total = userService.countUsers();
		return SUCCESS;
	}

	public String view() {
		user = userService.getUserById(uid);
		System.out.println(user);
		return SUCCESS;
	}

	public String modify() {
		user = userService.getUserById(uid);
		return SUCCESS;
	}

	public String remove() {
		userService.removeUserById(uid);
		return "list";
	}

}
