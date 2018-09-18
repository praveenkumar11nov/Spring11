package com.web.apps.serviceImpl;

import javax.jws.WebService;

import com.web.apps.service.SoapService;

@WebService(endpointInterface="com.web.apps.service.SoapService",name="Calculate",serviceName="Calculator",portName="Check")
public class SoapServiceImpl implements SoapService{

	@Override
	public int sum(int a, int b) {
		System.out.println("sum of "+a+" & "+b+" is "+(a+b));
		return a+b;
	}

	
}
