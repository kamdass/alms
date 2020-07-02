package com.anyware.lms.system.code.vo;

/**
 * @Date: 2020. 4. 26.
 *====================
 * @Description
 *  상세코드 vo
 */
public class CodeDtlVO
{
	String seq;						//시퀀스
	String master_code;			//마스터 코드
	String dtl_code;					//상세코드
	String dtl_code_nm;			//상세코드명
	String use_yn;					//사용여부
	String dtl_code_cont;			//상세코드 설명
	String reg_id;					//등록자 아이디
	String reg_dt;					//등록일시
	String upd_id;					//수정자 아이디
	String upd_dt;					//수정자 아이디
	
	//Getter & Setter =================================
	public String getSeq()
	{
		return seq;
	}
	public void setSeq(String seq)
	{
		this.seq = seq;
	}
	public String getMaster_code()
	{
		return master_code;
	}
	public void setMaster_code(String master_code)
	{
		this.master_code = master_code;
	}
	public String getDtl_code()
	{
		return dtl_code;
	}
	public void setDtl_code(String dtl_code)
	{
		this.dtl_code = dtl_code;
	}
	public String getDtl_code_nm()
	{
		return dtl_code_nm;
	}
	public void setDtl_code_nm(String dtl_code_nm)
	{
		this.dtl_code_nm = dtl_code_nm;
	}
	public String getUse_yn()
	{
		return use_yn;
	}
	public void setUse_yn(String use_yn)
	{
		this.use_yn = use_yn;
	}
	public String getDtl_code_cont()
	{
		return dtl_code_cont;
	}
	public void setDtl_code_cont(String dtl_code_cont)
	{
		this.dtl_code_cont = dtl_code_cont;
	}
	public String getReg_id()
	{
		return reg_id;
	}
	public void setReg_id(String reg_id)
	{
		this.reg_id = reg_id;
	}
	public String getReg_dt()
	{
		return reg_dt;
	}
	public void setReg_dt(String reg_dt)
	{
		this.reg_dt = reg_dt;
	}
	public String getUpd_id()
	{
		return upd_id;
	}
	public void setUpd_id(String upd_id)
	{
		this.upd_id = upd_id;
	}
	public String getUpd_dt()
	{
		return upd_dt;
	}
	public void setUpd_dt(String upd_dt)
	{
		this.upd_dt = upd_dt;
	}

	//toString =================================
	@Override
	public String toString()
	{
		return "CodeDtlVO [seq=" + seq + ", master_code=" + master_code + ", dtl_code=" + dtl_code + ", dtl_code_nm=" + dtl_code_nm + ", use_yn=" + use_yn + ", dtl_code_cont="
				+ dtl_code_cont + ", reg_id=" + reg_id + ", reg_dt=" + reg_dt + ", upd_id=" + upd_id + ", upd_dt=" + upd_dt + "]";
	}
}
