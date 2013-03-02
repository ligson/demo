package demo.service;

import java.io.File;
import java.util.List;

import demo.domain.User;

public interface UserService {
	public String register(User user);

	public boolean nameIsUnique(String name);

	public List<User> list(int offset, int max);

	public boolean login(String name, String password);

	public long countUsers();

	public User getUserById(String uid);

	public void modify(User user);

	public void removeUserById(String uid);

	public User getUserByNameAndPassword(String name, String password);

	public void modifyUserPicById(File file, String contentType, String uid);
}
