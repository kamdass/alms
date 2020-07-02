package com.anyware.lms.system.code.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.anyware.lms.system.code.service.CodeService;
import com.anyware.lms.system.code.vo.codeMasterVO;

/**
 * @Date: 2020. 4. 21.
 *====================
 * @Description
 * 마스터코드, 상세코드 컨트롤러
 */

@Controller
public class CodeController
{
	private static final Logger logger = LoggerFactory.getLogger(CodeController.class);
	
	 @Resource(name = "CodeService")
	 private CodeService service;
	 
	 

	/**
	 * @Date : 2020. 5. 20.
	 * @Name : goMasterCode
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	====================
	 * @Description
	 * 마스터코드 목록 화면으로 이동
	 */
	@RequestMapping(value = "/system/goMasterCode.do", method = RequestMethod.GET)
	public ModelAndView goMasterCode(HttpServletRequest request, HttpServletResponse response,codeMasterVO vo) throws Exception
	{
		logger.info("START");

		// ModelAndView 생성
		ModelAndView view = new ModelAndView();

		// 경로 설정
		String path = "[INT]system/code/codeList";
		
		//로직==========================================
		List<codeMasterVO> list = service.getMasterCodeList();

		// view 세팅
	    view.addObject("list",list);
		view.setViewName(path);
		return view;
	}
	
	/**
	 * @Date : 2020. 5. 20.
	 * @Name : masterCodeList
	 * @param locale
	 * @param model
	 * @param request
	 * @return
	 * @throws Exception
	====================
	 * @Description
	 *  마스터코드 목록 가져오기
	 */
	@RequestMapping(value = "/system/masterCodeList.do", method = {RequestMethod.GET ,RequestMethod.POST})
	public  @ResponseBody Map<String, Object> masterCodeList(HttpServletRequest request, HttpServletResponse response, codeMasterVO vo) throws Exception
	{
		
		logger.info("START");
		
		Map<String, Object> result = new HashMap<String, Object>();
		logger.info("vo=["+vo+"]");
		
		
		//로직==========================================
		List<codeMasterVO> list = service.getMasterCodeList();
		result.put("data", list);
		
		
		return result;
		
	}
	

	/**
	 * @Date : 2020. 5. 20.
	 * @Name : masterCodeList
	 * @param locale
	 * @param model
	 * @param request
	 * @return
	 * @throws Exception
	====================
	 * @Description
	 *  마스터코드 목록 가져오기
	 */
	@RequestMapping(value = "/system/masterCodeListDatatables.do", method = {RequestMethod.GET ,RequestMethod.POST})
	public  @ResponseBody Map<String, Object> masterCodeListDatatables(HttpServletRequest request, HttpServletResponse response, codeMasterVO vo) throws Exception
	{
		
		logger.info("START");
		
		Map<String, Object> result = new HashMap<String, Object>();
		logger.info("vo=["+vo+"]");
		
		
		//로직==========================================
		List<codeMasterVO> list = service.getMasterCodeList();
		result.put("data", list);
		
		
		return result;
		
	}
}
