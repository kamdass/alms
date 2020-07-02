package com.anyware.lms.menu.M02.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anyware.lms.menu.M02.mapper.M02Mapper;
import com.anyware.lms.menu.M02.service.M02Service;

@Service("M02Service")
public class M02ServiceImpl implements M02Service 
{

	private static final Logger logger = LoggerFactory.getLogger(M02ServiceImpl.class);
	
    @Autowired
    private M02Mapper mapper;
}
