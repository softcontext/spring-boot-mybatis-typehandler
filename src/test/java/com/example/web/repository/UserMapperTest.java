package com.example.web.repository;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.web.model.User;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
public class UserMapperTest {
	
	@Autowired
	private UserMapper userMapper;
	
	@Test
	public void testSelectUserById() {
		User user = new User();
		user.setUserName("Brad");
		user.setPassword("1111");
		System.out.println("1 >> "+user);
		
		int affected = userMapper.insertUser(user);
		assertEquals(affected, 1);
		System.out.println("2 >> "+user);
		
		User selectedUser = userMapper.selectUserById(user.getUserId());
		assert(selectedUser != null);
		assert(selectedUser.getUserName().equals(user.getUserName()));
		System.out.println("3 >> "+selectedUser);
	}

	@Test
	public void testInsertUser() {
		
	}

}
