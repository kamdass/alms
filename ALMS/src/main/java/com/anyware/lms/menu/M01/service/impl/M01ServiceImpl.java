package com.anyware.lms.menu.M01.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.anyware.lms.common.CommonMail;
import com.anyware.lms.common.CommonUtils;
import com.anyware.lms.common.vo.MemberVO;
import com.anyware.lms.menu.M01.mapper.M01Mapper;
import com.anyware.lms.menu.M01.service.M01Service;

/**
 * @Date: 2020. 7. 1
 * @FileName : M01ServiceImpl.java
 * @Author : dhkim2
 *====================
 * @Description
 *  - 로그인 관련 serviceImpl
 */
@Service("M01Service")
public class M01ServiceImpl implements M01Service 
{

	private static final Logger logger = LoggerFactory.getLogger(M01ServiceImpl.class);
	
    @Autowired
    private M01Mapper mapper;

	@Autowired
	private JavaMailSender mailSender;
    

	/**
	 * @Date 	: 2020. 7. 1
	 * @Name 	: M01ServiceImpl::checkLogin()
	 * @Author 	: dhkim2
	 * @param vo
	 * @param request
	 * @return
	 * @throws Exception
	 * ========================================
	 * @Description
	 *  - 로그인 체크
	 *  - 로그인 결과 값이 있는 경우 세션 생성
	*/
	@Override
	public boolean checkLogin(MemberVO vo,HttpServletRequest request) throws Exception 
	{
		logger.info("START");
		

		/*로직==========================================*/
		boolean returnVal = false;
		
		//로그인 체크 mapper 실행
		MemberVO resultVo = mapper.checkLogin(vo);
		
		//로그인 결과 분기처리
		if(!(CommonUtils.isEmpty(resultVo))) 
		{
			logger.info(resultVo+"");
			HttpSession session = request.getSession();
			session.setAttribute("loginSession", resultVo);
			
			returnVal = true;
		}

		/*return==========================================*/
		return returnVal;
	}


	/**
	 * @Date 	: 2020. 7. 1
	 * @Name 	: M01ServiceImpl::findIdPwd()
	 * @Author 	: dhkim2
	 * @param vo
	 * @return 	: 메세지 내용
	 * @throws Exception
	 * ========================================
	 * @Description
	 *  - 아이디, 비밀버호 찾기
	 *  - 비밀번호 찾기인 경우 임시 비밀번호 메일 전송
	*/
	@Override
	public Map<String, Object> findIdPwd(MemberVO vo) throws Exception 
	{
		logger.info("START");

		/*로직==========================================*/
		
		String msg = "";	
		String result = "";
		boolean mailResultFlag = true;
		Map<String, Object> map = new HashMap<String, Object>();
		
		//아이디 비밀번호 찾기 mapper 실행
		MemberVO resultVo = mapper.findIdPwd(vo);
		
		//resultVo 결과값이 null 이 아닐경우
		if(CommonUtils.isNotEmpty(resultVo)) 
		{	
			//flag == 1 : 아이디찾기
			if(vo.getFlag() == 1) 
			{
				msg = vo.getMemberNm() + "님의 아이디는 ["+resultVo.getMemberId()+"] 입니다.\n 로그인 화면으로 이동하시겠습니까?";
				
			}else		//flag ==2 : 비밀번호 찾기 
			{
				//select한 memberId 와 화면에서 입력한 아이디가 같을 경우
				if(resultVo.getMemberId().equals(vo.getMemberId()))	 
				{
					//mail 초기화
					CommonMail commonMail = new CommonMail(mailSender);	

					//메일 전송
					result = CommonUtils.sendMail(commonMail,resultVo);
					logger.info("result=["+result+"]");
					
					//메일 전송 결과값이 null 일경우 flase 아닐경우 true
					if(CommonUtils.isEmpty(result)) 
					{
						mailResultFlag = false;
					}else 
					{
						//발급한 임시 비밀번호를 DB에 update
						vo.setMemberPwd(result);					
						logger.info(vo+"");
						mapper.updateTmpPwd(vo);
						
						mailResultFlag = true;
					}
					
					msg = (mailResultFlag)? 
							"임시 비밀번호를 메일로 전송하였습니다. 로그인 화면으로 이동하시겠습니까?" 
							:"메일 전송이 실패되었습니다. 관리자에게 문의 하시기 바랍니다.";
					
				}else //select한 memberId 와 화면에서 입력한 아이디가 다를 경우
				{
					msg = "입력한 아이디와 검색한 결과가 달라 임시 비밀번호 발송이 실패되었습니다. 다시 확인해 주시기 바랍니다.";
					mailResultFlag = false;
				}
			}
		}else 
		{
			msg = "검색된 결과가 없습니다.관리자에게 문의하시기 바랍니다.";
			mailResultFlag = false;
		}

		map.put("mailResultFlag", mailResultFlag);
		map.put("msg", msg);

		/*return==========================================*/
		return map;
	}
}
