package com.anyware.lms.system.code.vo;

/**
 * @Date: 2020. 4. 26.
 *====================
 * @Description
 *  마스터코드 vo
 */
public class codeMasterVO
{
	String masterCode;		//마스터코드
	String masterCodeNm;	//마스터코드명
	String useYn;					//사용여부
	String masterCodeCont;	//마스터코드설명
	String regId;					//등록자아이디
	String regDt;					//등록 일시
	String updId;					//수정자아이디
	String updDt;				//수정일시
	
	//Getter & Setter =================================
	public String getMasterCode()
	{
		return masterCode;
	}
	public void setMasterCode(String masterCode)
	{
		this.masterCode = masterCode;
	}
	public String getMasterCodeNm()
	{
		return masterCodeNm;
	}
	public void setMasterCodeNm(String masterCodeNm)
	{
		this.masterCodeNm = masterCodeNm;
	}
	public String getUseYn()
	{
		return useYn;
	}
	public void setUseYn(String useYn)
	{
		this.useYn = useYn;
	}
	public String getMasterCodeCont()
	{
		return masterCodeCont;
	}
	public void setMasterCodeCont(String masterCodeCont)
	{
		this.masterCodeCont = masterCodeCont;
	}
	public String getRegId()
	{
		return regId;
	}
	public void setRegId(String regId)
	{
		this.regId = regId;
	}
	public String getRegDt()
	{
		return regDt;
	}
	public void setRegDt(String regDt)
	{
		this.regDt = regDt;
	}
	public String getUpdId()
	{
		return updId;
	}
	public void setUpdId(String updId)
	{
		this.updId = updId;
	}
	public String getUpdDt()
	{
		return updDt;
	}
	public void setUpdDt(String updDt)
	{
		this.updDt = updDt;
	}

	//toString =================================s
	@Override
	public String toString()
	{
		return "codeMasterVO [masterCode=" + masterCode + ", masterCodeNm=" + masterCodeNm + ", useYn=" + useYn + ", masterCodeCont=" + masterCodeCont + ", regId=" + regId
				+ ", regDt=" + regDt + ", updId=" + updId + ", updDt=" + updDt + "]";
	}
	
	
}
