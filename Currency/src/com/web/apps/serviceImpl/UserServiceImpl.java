package com.web.apps.serviceImpl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.web.apps.model.Users;
import com.web.apps.service.UserService;

@Repository
public class UserServiceImpl extends GenericServiceImpl<Users> implements UserService {

	@PersistenceContext(unitName="currency")
	protected EntityManager entityManager;
	
	@Override
	public int validate(String name,String pwd) {
		Object[] valid=(Object[]) entityManager.createNativeQuery("select * from USERS where NAME='"+name+"' and PASSWORD='"+pwd+"'").getSingleResult();
		System.err.println("valid.length============>"+valid.length);
		if(valid.length==0){
			return 0;
		}else{
			return 1;
		}
		
	}

}
