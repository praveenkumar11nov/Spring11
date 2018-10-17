package com.web.apps.service;

import com.web.apps.model.Users;


public interface UserService extends GenericService<Users>{
	public int validate(String name,String pwd);
	
}
