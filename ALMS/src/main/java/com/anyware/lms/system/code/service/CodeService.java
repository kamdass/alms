package com.anyware.lms.system.code.service;

import java.util.List;

import com.anyware.lms.system.code.vo.codeMasterVO;

public interface CodeService
{

	List<codeMasterVO> getMasterCodeList() throws Exception;

}
