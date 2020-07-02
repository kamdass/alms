package com.anyware.lms.login.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.anyware.lms.login.service.LoginService;
import com.anyware.lms.system.code.vo.codeMasterVO;

@Controller
public class LoginController
{

	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	 @Resource(name = "LoginService")
	 private LoginService service;
	 

		@RequestMapping(value = "/login.do", method = RequestMethod.GET)
		public ModelAndView goLogin(HttpServletRequest request, HttpServletResponse response,codeMasterVO vo) throws Exception
		{
			logger.info("START");

			// ModelAndView 생성
			ModelAndView view = new ModelAndView();

			// 경로 설정
			String path = "[LOGIN]login/login.jsp";
			
			//로직==========================================

			// view 세팅
			view.setViewName(path);
			return view;
		}
}
