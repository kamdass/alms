package com.anyware.lms.menu.M01.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.anyware.lms.common.vo.MemberVO;

/**
 * @Date: 2020. 7. 1
 * @FileName : M01Service.java
 * @Author : dhkim2
 *====================
 * @Description
 *  - 로그인 service
 */
public interface M01Service 
{
	/**
	 * @Date 	: 2020. 7. 1
	 * @Name 	: M01Service::checkLogin()
	 * @Author 	: dhkim2
	 * @param vo
	 * @param request
	 * @return
	 * @throws Exception
	 * ========================================
	 * @Description
	 *  - 로그인 체크
	*/
	boolean checkLogin(MemberVO vo,HttpServletRequest request) throws Exception;

	/**
	 * @Date 	: 2020. 7. 1
	 * @Name 	: M01Service::findIdPwd()
	 * @Author 	: dhkim2
	 * @param vo
	 * @return
	 * @throws Exception
	 * ========================================
	 * @Description
	 *  - 아이디, 비밀번호 찾기
	*/
	Map<String, Object> findIdPwd(MemberVO vo) throws Exception;

}
