package demo.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.web.context.ServletConfigAware;

import com.opensymphony.xwork2.ActionSupport;

import demo.domain.User;
import demo.service.MailService;
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
	private String fileName;
	private Map<String, Object> result = new HashMap<String, Object>();

	public User getUser() {
		return user;
	}

	public Map<String, Object> getResult() {
		return result;
	}

	public void setResult(Map<String, Object> result) {
		this.result = result;
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

	public InputStream getExcelInputStream() {
		users = userService.list(offset, max);
		File file = userService.buildExcel(users);
		setFileName(file.getName());
		FileInputStream fileInputStream;
		try {
			fileInputStream = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		}
		return fileInputStream;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String sendMail() {
		HttpServletRequest request = ServletActionContext.getRequest ();
		User currentUser = (User) request.getSession().getAttribute("currentUser");
		userService.sendMail(currentUser,getUid());
		return SUCCESS;
	}

}
