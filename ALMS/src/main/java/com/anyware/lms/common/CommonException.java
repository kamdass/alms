package com.anyware.lms.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * @date 			: 2019. 12. 9.
 * @fileName	: CmnException.java
 * @desc			: 공통 Exception 처리  
 */
@ControllerAdvice(basePackages = {"com.anyware.lms"})
public class CommonException
{
    public static final String DEFAULT_ERROR_VIEW = "common/error";

    private static final Logger logger = LoggerFactory.getLogger(CommonException.class);
    
    /**
     * @date 					: 2019. 12. 9.
     * @return				: ModelAndView
     * @desc					: error 페이지 이동
     */
    @ExceptionHandler(Exception.class)
    public ModelAndView exceptionController(Exception e) 
    {
        logger.info("START");
        ModelAndView view = new ModelAndView(); 
        
        logger.error("Exception Message=["+e.getMessage()+"]");
        view.addObject("msg", e.getMessage());
        view.addObject("flag", "error");
        view.setViewName(DEFAULT_ERROR_VIEW);
        
        return view;
    }
}