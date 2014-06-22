/**
 * Copyright (c) 2014. Designed By BaiQiang.
 */
package org.bq.test;

import java.util.Iterator;
import java.util.List;

import org.bq.dao.UserDAO;
import org.bq.model.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author °×Ç¿
 * @version 1.0
 */
public class UserDAOTest {
	private UserDAO dao;
	ApplicationContext ctx;

	@Before
	public void init() {
		ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		dao = (UserDAO) ctx.getBean("userDAO");
	}

	@Test
	public void testAddUser() {
		User user = new User("test1", "bq", 10, "image");
		dao.addUser(user);
	}

	@Test
	public void testQueryAll() {
		List<User> list = dao.queryAll();
		for (Iterator<User> iterator = list.iterator(); iterator.hasNext();) {
			User user = (User) iterator.next();
			System.out.println(user);

		}
	}

	@Test
	public void testGetUser() {
		User user = dao.getUser("test1");
		System.out.println(user);
	}

	@Test
	public void testUpdateObject() {
		User user = dao.getUser("test1");
		user.setName("update");
		dao.updateUser("test1", user);
	}

	@Test
	public void testRemove() {
		dao.remove("test1");
	}

	@After
	public void destory() {
	}
}
