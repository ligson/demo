package demo.test;

import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import demo.dao.UserDao;
import demo.domain.User;
import demo.util.DateUtils;

public class UserDaoTest {
	ApplicationContext context = new ClassPathXmlApplicationContext(
			"spring-conf.xml");

	public void addUserTest() {
		User user = (User) context.getBean("user");
		user.setBirth(DateUtils.dateToDbFormat(new Date()));
		user.setName("test4");
		user.setEmail("aas@aa.com");
		user.setPassword("password");
		user.setSex(true);

		UserDao userDao = (UserDao) context.getBean("userDao");
		String id = userDao.add(user);
		System.out.println(id);
	}

	//@Test
	public void batchCreateUserTest() {
		for (int i = 0; i <= 100; i++) {
			User user = (User) context.getBean("user");
			user.setBirth(DateUtils.dateToDbFormat(new Date()));
			user.setName("TestUser" + i);
			user.setEmail("tuser" + i + "@aa.com");
			user.setPassword("password");
			user.setSex(i % 2 == 0);
			UserDao userDao = (UserDao) context.getBean("userDao");
			userDao.add(user);
		}
	}

	public void testCount() {
		UserDao userDao = (UserDao) context.getBean("userDao");
		long count = userDao.countBy(null, null);
		Assert.assertEquals(count, 4);
	}

	public void testFindAll() {
		UserDao userDao = (UserDao) context.getBean("userDao");
		List<User> list = userDao.findAllBy(null, null, 0, 10);
		Assert.assertEquals(list.size(), 8);
	}
}
