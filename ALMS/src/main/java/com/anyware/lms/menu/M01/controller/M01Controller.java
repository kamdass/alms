package com.anyware.lms.menu.M01.controller;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.anyware.lms.common.vo.MemberVO;
import com.anyware.lms.menu.M01.service.M01Service;

/**
 * @Date: 2020. 7. 1
 * @FileName : M01Controller.java
 * @Author : dhkim2
 *====================
 * @Description
 *  - 로그인 관련 controller
 */
@Controller
public class M01Controller 
{
	private static final Logger logger = LoggerFactory.getLogger(M01Controller.class);
	
	@Resource(name = "M01Service")
	private M01Service service;
	
	@Autowired 
	MessageSource messageSource;
	 

	/**
	 * @Date 	: 2020. 7. 1
	 * @Name 	: M01Controller::goLogin()
	 * @Author 	: dhkim2
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 * ========================================
	 * @Description
	 *  - 로그인 화면으로 이동
	*/
	@RequestMapping(value = "/M010101.do", method = {RequestMethod.GET ,RequestMethod.POST})
	public ModelAndView goLogin(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		logger.info("START");

		// ModelAndView 생성
		ModelAndView view = new ModelAndView();

		
		/*로직==========================================*/
		
		// view 세팅
		view.setViewName("[ML]01/M010101");
		
		/*return==========================================*/
		return view;
	}
		
	/**
	 * @Date 	: 2020. 7. 1
	 * @Name 	: M01Controller::loginProc()
	 * @Author 	: dhkim2
	 * @param request
	 * @param response
	 * @param vo
	 * @return
	 * @throws Exception
	 * ========================================
	 * @Description
	 *  - 로그인 버튼 클릭시, 로그인 여부 체크
	 *  - ajax 
	*/
	@RequestMapping(value = "/M01F001.do", method = {RequestMethod.GET ,RequestMethod.POST})
	@ResponseBody
	public boolean loginProc(HttpServletRequest request, HttpServletResponse response, MemberVO vo) throws Exception
	{
		logger.info("START");

		/*로직==========================================*/


		/*return==========================================*/
		return service.checkLogin(vo,request);
	}
		

	/**
	 * @Date 	: 2020. 7. 1
	 * @Name 	: M01Controller::goFindMemberInfo()
	 * @Author 	: dhkim2
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 * ========================================
	 * @Description
	 *  - 아이디 찾기 또는 비밀번호 찾기 화면으로 이동 
	 *  - M010101 화면에서 받은 findFlag 값에 넘김 
	*/
	@RequestMapping(value = "/M010201.do", method = {RequestMethod.GET ,RequestMethod.POST})
	public ModelAndView goFindMemberInfo(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		logger.info("START");

		// ModelAndView 생성
		ModelAndView view = new ModelAndView();


		/*로직==========================================*/
		
		// view 세팅
		view.addObject("flag",request.getParameter("findFlag"));
		view.setViewName("[ML]01/M010201");

		/*return==========================================*/
		return view;
	}
	

	/**
	 * @Date 	: 2020. 7. 1
	 * @Name 	: M01Controller::findProc()
	 * @Author 	: dhkim2
	 * @param request
	 * @param response
	 * @param vo
	 * @return
	 * @throws Exception
	 * ========================================
	 * @Description
	 *  - 찾기 버튼 클릭 시 실행되는 method
	 *  - 
	*/
	@RequestMapping(value = "/M01F002.do", method = {RequestMethod.GET ,RequestMethod.POST})
	@ResponseBody
	public Map<String, Object> findProc(HttpServletRequest request, HttpServletResponse response,MemberVO vo) throws Exception
	{
		logger.info("START");
		

		/*로직==========================================*/

		/*return==========================================*/
		return service.findIdPwd(vo);
	}
		
}
