package com.anyware.lms.common.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString() 
//@ToString(exclude = "memberPwd") //비밀번호는 제외
public class MemberVO 
{
	private String memberId;
	private String memberPwd;
	private String memberNm;
	private String memberGender;
	private String member_birth;
	private String memberPhone;
	private String memberGb;
	private String memberUseYn;
	private String regId;
	private String regDt;
	private String updId;
	private String updDt;
	
	//기능=======================================
	private int flag;
	private String tmpPwd;
	
	//getter & setter ================================

}
