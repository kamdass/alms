package com.anyware.lms.system.code.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.anyware.lms.system.code.vo.codeMasterVO;

@Mapper
public interface CodeMapper
{

	List<codeMasterVO> getMasterCodeList() throws Exception;

}
