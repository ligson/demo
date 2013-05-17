package demo.role.action;

import java.util.HashMap;
import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;

import demo.domain.Role;
import demo.service.RoleService;

public class ModifyRoleAction extends ActionSupport {

	private Role role;
	private String roleId;
	private String roleName;
	private Map<String, Object> result = new HashMap<String, Object>();
	private RoleService roleService;

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public RoleService getRoleService() {
		return roleService;
	}

	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}

	public Map<String, Object> getResult() {
		return result;
	}

	public void setResult(Map<String, Object> result) {
		this.result = result;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String modifyRoleName() {
		try {
			roleService.modifyRoleName(getRoleId(), getRoleName());
			result.put("result", "success");
		} catch (Exception e) {
			result.put("result","fail");
		}
		return SUCCESS;
	}

}
