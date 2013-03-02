package demo.role.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;

import demo.domain.Role;
import demo.service.RoleService;

public class RoleTreeAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Role role;
	private RoleService roleService;
	private String pid;
	private List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
	private Map<String, Object>	resultMap = new HashMap<String, Object>();
	
	
	public Map<String, Object> getResultMap() {
		return resultMap;
	}

	public void setResultMap(Map<String, Object> resultMap) {
		this.resultMap = resultMap;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	

	public List<Map<String, Object>> getResult() {
		return result;
	}

	public void setResult(List<Map<String, Object>> result) {
		this.result = result;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public RoleService getRoleService() {
		return roleService;
	}

	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}

	public String createRole() throws Exception {
		System.out.println("createRole" + getRole());
		if (role != null) {
			if(pid!=null&&(!pid.equals(""))){
				Role fatherRole = roleService.getById(pid);
				role.setFatherRole(fatherRole);
			}
			roleService.createRole(role);
			System.out.println("success");
			return SUCCESS;
		} else {
			System.out.println("error");
			return ERROR;
		}
	}
	public String removeRole(){
		roleService.removeRoleById(pid);
		return SUCCESS;
	}
	public String countChildRole(){
		int count = roleService.searchRolesByFatherId(pid).size();
		resultMap.put("count", count);
		return SUCCESS;
	}

	public String list() {
		List<Role> list = roleService.searchRolesByFatherId(pid);
		for(Role role:list){
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("id", role.getId());
			map.put("name", role.getName());
			if(role.getFatherRole()==null){
				map.put("pid", null);
			}else{
				map.put("pid", role.getFatherRole().getId());
			}
			map.put("isParent", role.isParent());
			result.add(map);
		}
		return SUCCESS;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return SUCCESS;
	}

}
