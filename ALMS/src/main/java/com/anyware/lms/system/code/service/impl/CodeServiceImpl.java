package com.anyware.lms.system.code.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anyware.lms.system.code.mapper.CodeMapper;
import com.anyware.lms.system.code.service.CodeService;
import com.anyware.lms.system.code.vo.codeMasterVO;

@Service("CodeService")
public class CodeServiceImpl implements CodeService
{

	private static final Logger logger = LoggerFactory.getLogger(CodeServiceImpl.class);
	
    @Autowired
    private CodeMapper mapper;
	
	@Override
	public List<codeMasterVO> getMasterCodeList() throws Exception
	{
		logger.info("start");
		
		List<codeMasterVO> result = mapper.getMasterCodeList();
		
		return result;
		
	}

}
