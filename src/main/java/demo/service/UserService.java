package demo.service;

import java.io.File;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import demo.domain.User;

@WebService
public interface UserService {
	@WebMethod
	public String register(User user);

	@WebMethod
	public boolean nameIsUnique(String name);

	public List<User> list(int offset, int max);

	public boolean login(String name, String password);

	public long countUsers();

	public User getUserById(String uid);

	public void modify(User user);

	public void removeUserById(String uid);

	public User getUserByNameAndPassword(String name, String password);

	public void modifyUserPicById(File file, String contentType, String uid);

	@WebMethod(exclude=true)
	public File buildExcel(List<User> users);
	@WebMethod(exclude=true)
	public void sendMail(User currentUser,String receiverId);
	
}
