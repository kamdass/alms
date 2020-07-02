package com.anyware.lms.menu.M01.mapper;

import com.anyware.lms.common.vo.MemberVO;

/**
 * @Date : 2020. 6. 25.
 * @File : M01Mapper.java
 * ===========================
 * @Description 
 *  - 로그인 관련 Mapper Interface
*/
public interface M01Mapper 
{
	/**
	 * @Date 	: 2020. 7. 1
	 * @Name 	: M01Mapper::checkLogin()
	 * @Author 	: dhkim2
	 * @param vo
	 * @return
	 * @throws Exception
	 * ========================================
	 * @Description
	 *  - 로그인 체크
	*/
	MemberVO checkLogin(MemberVO vo) throws Exception;

	/**
	 * @Date 	: 2020. 7. 1
	 * @Name 	: M01Mapper::findIdPwd()
	 * @Author 	: dhkim2
	 * @param vo
	 * @return
	 * @throws Exception
	 * ========================================
	 * @Description
	 *  - 아이디, 비밀번호찾기 
	*/
	MemberVO findIdPwd(MemberVO vo) throws Exception;

	/**
	 * @Date 	: 2020. 7. 1
	 * @Name 	: M01Mapper::updateTmpPwd()
	 * @Author 	: dhkim2
	 * @param vo
	 * @throws Exception
	 * ========================================
	 * @Description
	 *  - 발금된 임시비밀번호 update 
	*/
	void updateTmpPwd(MemberVO vo) throws Exception;

}
