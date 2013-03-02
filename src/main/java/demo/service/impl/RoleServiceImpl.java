package demo.service.impl;

import java.util.List;

import demo.dao.ResourceGroupDao;
import demo.dao.RoleDao;
import demo.dao.UserGroupDao;
import demo.domain.Role;
import demo.domain.User;
import demo.domain.UserGroup;
import demo.service.RoleService;

public class RoleServiceImpl implements RoleService {

	private RoleDao roleDao;
	private ResourceGroupDao resourceGroupDao;
	private UserGroupDao userGroupDao;

	
	public RoleDao getRoleDao() {
		return roleDao;
	}

	public void setRoleDao(RoleDao roleDao) {
		this.roleDao = roleDao;
	}

	public ResourceGroupDao getResourceGroupDao() {
		return resourceGroupDao;
	}

	public void setResourceGroupDao(ResourceGroupDao resourceGroupDao) {
		this.resourceGroupDao = resourceGroupDao;
	}

	public UserGroupDao getUserGroupDao() {
		return userGroupDao;
	}

	public void setUserGroupDao(UserGroupDao userGroupDao) {
		this.userGroupDao = userGroupDao;
	}

	@Override
	public String createRole(Role role) {
		try {
			Role fatherRole = role.getFatherRole();
			if(fatherRole != null){
				role.setLevel(role.getFatherRole().getLevel()+1);
				fatherRole.setParent(true);
				roleDao.update(fatherRole);
			}
			role.setParent(false);
			return roleDao.add(role);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public void removeRoleById(String id) {
		Role role = roleDao.getById(id);
		if (role != null) {
			roleDao.delete(role);
		}
	}

	@Override
	public void changeRoleFather(String roleId, String destId) {
		Role role = roleDao.getById(roleId);
		Role dest = roleDao.getById(destId);
		if (role != null && dest != null) {
			role.setFatherRole(dest);
			roleDao.saveOrUpdate(role);
		}
	}

	@Override
	public void modifyRoleName(String id, String name) {
		// TODO Auto-generated method stub
		long count = roleDao.countBy("name", name);
		if (count == 0) {
			Role role = roleDao.getById(id);
			role.setName(name);
			roleDao.saveOrUpdate(role);
		}
	}

	@Override
	public void addUserToRole(String id, List<User> users) {
		// TODO Auto-generated method stub
		Role role = roleDao.getById(id);
		for(User user : users){
			UserGroup userGroup = new UserGroup();
			userGroup.setRole(role);
			userGroup.setUser(user);
			userGroupDao.add(userGroup);
		}
	}

	@Override
	public void removeUserFromRole(String id, List<User> users) {
		// TODO Auto-generated method stub
		Role role = roleDao.getById(id);
		List<UserGroup> list = userGroupDao.findAllBy("role", role);
		for(User user:users){
			UserGroup userGroup1 = null;
			for(UserGroup userGroup:list){
				if(userGroup.getUser().getId().equals(user.getId())){
					userGroup1 = userGroup;
					break;
				}
			}
			if(userGroup1!=null){
				userGroupDao.delete(userGroup1);
			}
			
		}
	}

	@Override
	public List<Role> searchRolesByFatherId(String fid) {
		// TODO Auto-generated method stub
		if(fid==null){
			return roleDao.findAllBy("fatherRole", null);
		}else{
			Role role = roleDao.getById(fid);
			return roleDao.findAllBy("fatherRole.id", role.getId());
		}
	}

	@Override
	public Role getById(String fatherId) {
		// TODO Auto-generated method stub
		return roleDao.getById(fatherId);
	}

}
