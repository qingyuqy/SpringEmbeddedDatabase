package com.qingyu.sample.dao;

import static org.junit.Assert.*;

import java.sql.SQLException;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.qingyu.sample.vo.User;

@ContextConfiguration(locations={"classpath*:dao-test.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class TestUserDAO {

	UserDAO userDAO;
	
	@Resource
	DataSource dataSource;
	
	@Before
	public void setUp(){
		userDAO = new UserDAO();
		try {
			userDAO.setConn(dataSource.getConnection());
		} catch (SQLException e) {
			System.out.println("SQLException" + e.getMessage());
		}
	}
	
	@Test
	public void testGetUser() {
		User user = userDAO.getUser("qingyu");
		assertNotNull(user);
		assertEquals("qingyu", user.getPassword());
		
	}

}
