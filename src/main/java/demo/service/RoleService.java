package demo.service;

import java.util.List;

import demo.domain.Role;
import demo.domain.User;

public interface RoleService {
	public String createRole(Role role);

	/**
	 * 删除一个角色
	 * @param id
	 */
	public void removeRoleById(String id);

	/**
	 * 更改一个角色的上级
	 * 
	 * @param roleId
	 *            要改变的角色id
	 * @param destId
	 *            目标角色
	 */
	public void changeRoleFather(String roleId, String destId);

	public void modifyRoleName(String id, String name);
	/**
	 * 移动用户到角色
	 * @param id
	 * @param users
	 */
	public void addUserToRole(String id,List<User> users);
	/**
	 * 从角色下移除部分用户
	 * @param id
	 * @param users
	 */
	public void removeUserFromRole(String id,List<User> users);
	
	/**
	 * 寻找一个角色下的所有子角色
	 * @param fid
	 * @return
	 */
	public List<Role> searchRolesByFatherId(String fid);

	public Role getById(String fatherId);
}
