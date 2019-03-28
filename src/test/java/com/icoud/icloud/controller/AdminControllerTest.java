package com.icoud.icloud.controller;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;

import cn.com.icloud.service.system.UserService;

public class AdminControllerTest extends BaseControllerTest {

	@Resource
	UserService userService;
    
	@Test
	public void testInfo() {
	}

	@Test
	public void testLogin() {
//		userService.findBy("account", "admin");
		Assert.assertNotNull(userService.findBy("account", "admin"));
	}

	@Test
	public void testLogout() {
	}

}
