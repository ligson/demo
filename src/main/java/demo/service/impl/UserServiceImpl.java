package demo.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import demo.dao.UserDao;
import demo.domain.User;
import demo.service.UserService;

public class UserServiceImpl implements UserService {

	private UserDao userDao;

	@Override
	public String register(User user) {
		return userDao.add(user);
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public boolean nameIsUnique(String name) {
		return userDao.propertyIsUnique("name", name);
	}

	@Override
	public List<User> list(int offset, int max) {
		// TODO Auto-generated method stub
		return userDao.findAllBy(null, null, offset, max);
	}

	@Override
	public boolean login(String name, String password) {
		// TODO Auto-generated method stub
		List<String> names = new ArrayList<String>();
		names.add("name");
		names.add("password");

		List<Object> values = new ArrayList<Object>();
		values.add(name);
		values.add(password);

		User user = userDao.findByAnd(names, values);

		return user != null;

	}

	@Override
	public long countUsers() {
		// TODO Auto-generated method stub
		return userDao.countBy(null, null);
	}

	@Override
	public User getUserById(String uid) {
		// TODO Auto-generated method stub
		return userDao.getById(uid);
	}

	@Override
	public void modify(User user) {
		// TODO Auto-generated method stub
		userDao.update(user);
	}

	@Override
	public void removeUserById(String uid) {
		// TODO Auto-generated method stub
		User user = userDao.getById(uid);
		userDao.delete(user);
	}

	@Override
	public User getUserByNameAndPassword(String name, String password) {
		// TODO Auto-generated method stub
		List<String> names = new ArrayList<String>();
		List<Object> values = new ArrayList<Object>();

		names.add("name");
		names.add("password");
		values.add(name);
		values.add(password);
		return userDao.findByAnd(names, values);
	}

	@Override
	public void modifyUserPicById(File file, String contentType, String uid) {
		// TODO Auto-generated method stub

		HttpServletRequest request = ServletActionContext.getRequest();

		// application/x-bmp,application/x-jpg,image/jpeg,application/x-png,image/png

		if (contentType.equalsIgnoreCase("application/x-bmp")
				|| contentType.equalsIgnoreCase("image/bmp")) {
			contentType = ".bmp";
		} else if (contentType.equalsIgnoreCase("application/x-jpg")
				|| contentType.equalsIgnoreCase("image/jpeg")) {
			contentType = ".jpg";
		} else if (contentType.equalsIgnoreCase("application/x-png")
				|| contentType.equalsIgnoreCase("image/png")) {
			contentType = ".png";
		} else {
			throw new RuntimeException("file type error!");
		}
		String destName = "upload/user/" + UUID.randomUUID().toString()
				+ contentType;
		File dest = new File(request.getRealPath("/"), destName);
		try {
			FileUtils.copyFile(file, dest);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(request.getContextPath());
		System.out.println(request.getRealPath("/"));
		userDao.updateProperty("pic", destName, uid);
	}

}
