package com.anyware.lms.cloud.test.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.anyware.lms.menu.M01.service.M01Service;

@RestController
public class restFulController 
{
	private static final Logger logger = LoggerFactory.getLogger(restFulController.class);
	
	@Resource(name = "M01Service")
	private M01Service service;
	
	
	
//	@RequestMapping(value = "/loginTest.do", method = {RequestMethod.GET ,RequestMethod.POST})
//	public String goLoginTest(HttpServletRequest request, HttpServletResponse response) throws Exception
//	{
//		logger.info("START");
//
//		// ModelAndView 생성
//		ModelAndView view = new ModelAndView();
//
//		
//		/*로직==========================================*/
//		
//		// view 세팅
//		view.setViewName("[ML]01/M010101");
//		
//		/*return==========================================*/
//		return view;
//	}
}
