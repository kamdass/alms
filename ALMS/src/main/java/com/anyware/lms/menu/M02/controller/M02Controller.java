package com.anyware.lms.menu.M02.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.anyware.lms.menu.M02.service.M02Service;

@Controller
public class M02Controller 
{
	private static final Logger logger = LoggerFactory.getLogger(M02Controller.class);

	 @Resource(name = "M02Service")
	 private M02Service service;
	 
	@RequestMapping(value = "/M020101.do", method = {RequestMethod.GET ,RequestMethod.POST})
	public ModelAndView goMain(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		logger.info("START");

		// ModelAndView 생성
		ModelAndView view = new ModelAndView();

		// 경로 설정
		String path = "[M]02/M020101";
		
		//로직==========================================

		// view 세팅
		view.setViewName(path);
		return view;
	}
}
