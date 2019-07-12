package com.web.apps.unitTest;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.web.apps.utils.TestBeanConfig;
import com.web.apps.controller.UserController;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestBeanConfig.class})
public class UserControllerTest {
	
	@Autowired
	private UserController userController;

	@Test
	public void sum_Test() {
		double sumed=userController.sum(2,3);
		System.out.println("Result received while testing mthod : " + sumed);
		assertNotNull(sumed);
		assertEquals(sumed+"", "5.0");
		assertTrue(sumed>0);
		
	}
}
