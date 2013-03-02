package demo.action;

import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;

import demo.service.UserService;

public class CheckNameUniqueAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String userName;
	private Map<String, Object> resultMap;
	private UserService userService;
	private boolean nameIsUnique;

	public boolean isNameIsUnique() {
		return nameIsUnique;
	}

	public void setNameIsUnique(boolean nameIsUnique) {
		this.nameIsUnique = nameIsUnique;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Map<String, Object> getResultMap() {
		return resultMap;
	}

	public void setResultMap(Map<String, Object> resultMap) {
		this.resultMap = resultMap;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@Override
	public String execute() throws Exception {
		if (userService.nameIsUnique(getUserName())) {
			nameIsUnique = true;
		} else {
			nameIsUnique = false;
		}
		resultMap.clear();
		resultMap.put("nameIsUnique", nameIsUnique);
		return SUCCESS;
	}

}
