package com.anyware.lms.login.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anyware.lms.login.mapper.LoginMapper;
import com.anyware.lms.login.service.LoginService;

@Service("LoginService")
public class LoginServiceImpl implements LoginService
{


	private static final Logger logger = LoggerFactory.getLogger(LoginServiceImpl.class);
	
    @Autowired
    private LoginMapper mapper;
}
