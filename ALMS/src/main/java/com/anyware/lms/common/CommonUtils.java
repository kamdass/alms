package com.anyware.lms.common;

import java.text.DecimalFormat;
import java.util.Enumeration;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import com.anyware.lms.common.vo.MemberVO;

/**
 * @Date : 2020. 6. 24.
 * @File : CommonUtils.java
 * @Author : dhkim2
 * ===========================
 * @Description 
 *  - 유틸리티 클래스
 *  - StringUtils 상속
*/
public class CommonUtils extends StringUtils
{

	private static final Logger logger = LoggerFactory.getLogger(CommonUtils.class);

	/**
	 * @Date 	: 2020. 7. 1
	 * @Name 	: CommonUtils::isNotEmpty()
	 * @Author 	: dhkim2
	 * @param str
	 *  - 체크하고자 하는 Object 변수
	 * @return
	 *  - true : 값이 있음
	 *  - false : 값이 없음
	 * ========================================
	 * @Description
	 *  - isEmpty 함수 반대
	*/
	public static boolean isNotEmpty(Object str) 
	{
		return !isEmpty(str);
	}
	

	/**
	 * @Date 	: 2020. 7. 1
	 * @Name 	: CommonUtils::addComma()
	 * @Author 	: dhkim2
	 * @param val
	 * @return
	 *  - String 
	 * ========================================
	 * @Description
	 *  - 세자리 마다 콤마 붙이기
	*/
	public static String addComma(Object val)
	{
		DecimalFormat dF = new DecimalFormat("###,###");

		return dF.format(val);

	}


	/**
	 * @Date 	: 2020. 7. 1
	 * @Name 	: CommonUtils::changeMap()
	 * @Author 	: dhkim2
	 * @param request
	 * @return
	 * ========================================
	 * @Description
	 *  - request.getParamget에서 가져온 값을 Map 형태로 변환
	*/
	public static HashMap<String, Object> changeMap(HttpServletRequest request)
	{
		HashMap<String, Object> result = new HashMap<String, Object>();

		Enumeration<?> e = request.getParameterNames();

		String paramKey = "";
		String[] paramValue = null;

		while (e.hasMoreElements())
		{
			paramKey = (String) e.nextElement();
			paramValue = request.getParameterValues(paramKey);

			result.put(paramKey, (paramValue.length > 1) ? paramValue : paramValue[0]);
		}
		return result;
	}



	/**
	 * @Date 	: 2020. 7. 1
	 * @Name 	: CommonUtils::sendMail()
	 * @Author 	: dhkim2
	 * @param commonMail
	 * @param vo
	 * @return
	 *  - 임시 비밀번호 값
	 * ========================================
	 * @Description
	 *  - 임시 비밀번호 메일 발송
	*/
	@SuppressWarnings("finally")
	public static String sendMail(CommonMail commonMail, MemberVO vo) 
	{
		
		logger.info("START");
		String tmpPwd = setTmpPwd();
		
		try 
		{
			//메일 세팅
			commonMail.setSubject("[LMS] 임시 비밀번호 발급 완료");	//제목
			commonMail.setText("임시 비밀번호는 ["+tmpPwd+"] 입니다. 재로그인 후 비밀번호를 변경하시기 바랍니다.");//내용
			commonMail.setFrom("LMS_MAIL_ADMIN","educationiot@gmail.com");	//보내는 사람. 해당값을 수정할 경우 root-context.xml bean도 수정해야 함
			commonMail.setTo(vo.getMemberId());	//받는사람
			
			//메일 전송
			commonMail.send();
			
		} catch (Exception e) 
		{
			tmpPwd = "";
		}finally 
		{
			return tmpPwd;
		}
	}
	
	/**
	 * @Date 	: 2020. 7. 1
	 * @Name 	: CommonUtils::setTmpPwd()
	 * @Author 	: dhkim2
	 * @return
	 * ========================================
	 * @Description
	 *  - 임의의 10자리 임시비밀번호 생성
	*/
	public static String setTmpPwd() 
	{
		int index = 0; 
		
		char[] charArr = new char[] { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 
				'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 
				'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 
				'w', 'x', 'y', 'z' };
		
		StringBuffer sb = new StringBuffer(); 

		for (int i = 0; i < 10; i++) 
		{ 
			index = (int) (charArr.length * Math.random()); 
			sb.append(charArr[index]); 
		} 

		return sb.toString();
	}
}
