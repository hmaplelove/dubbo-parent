package com.hmaplelove.apps.commons.service.impl;

import com.hmaplelove.apps.commons.service.UserService;

public class UserServiceImpl implements UserService {

	public String sayHello(String content) {
		return "provider====>"+content;
	}

}
