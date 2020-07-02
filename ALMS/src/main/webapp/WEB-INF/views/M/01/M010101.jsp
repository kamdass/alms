<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%--===============================================
    *Date 		: 2020. 6. 17.
    *FileName 	: M010101.jsp
    *Author 	: dhkim2
    *Description 		
    * - 로그인 화면
===============================================--%>


<%--script::START============================================ --%>
<script type="text/javascript">
$(function() {
	var msg = "${result}";

	if(msg !="")
	{
		alert(msg);
		return false;
	}

	<%--로그인 버튼 클릭 시--%>
	$("#btnSubmit").click(function(){
		if(isValid("loginForm"))
			{
		        var param = $("#loginForm").serialize() ;
		 
		        $.ajax({
		            type : "post"
		            , url : "/M01F001.do"
		            , data : param
		            , dataType : "json"
		            , error: function(xhr, status, error)
		            {
		                alert("데이터 처리중 에러가 발생되었습니다. 관리자에게 문의하시기 바랍니다.");
		                return false;
		            }
		            , success : function(result)
		            {
			            if(result)
			            {
				            location.href = "/M020101.do";
			            }
			            else
			            {
				            alert("아이디 또는 비밀번호를 다시 확인해 주시기 바랍니다.");
				            return false;
			            }
		            }
		        });
			}
		});

	<%--아이디 찾기 클릭 시--%>
	$("#findId").click(function(){
		$("#findFlag").val(1);
		$("#frmSubmit").submit();
		});
	
	<%--비밀번호 찾기 클릭 시--%>
	$("#findPwd").click(function(){
		$("#findFlag").val(2);
		$("#frmSubmit").submit();
		});
});
</script>
<%--script::END============================================= --%>

<form id="frmSubmit" method="post" action="/M010201.do">
	<input type="hidden" id="findFlag" name="findFlag" value=""/>	<%--아이디찾기, 비밀번호 찾기 구분값 --%>
</form>

<div class="container">
	<div class="row justify-content-center">
		<div class="col-xl-10 col-lg-12 col-md-9">
			<div class="card o-hidden border-0 shadow-lg my-5">
				<div class="card-body p-0">
					<div class="row">
						<div class="col-lg-6 d-none d-lg-block bg-login-image"></div>
						<div class="col-lg-6">
							<div class="p-5">
								<div class="text-center">
									<h1 class="h4 text-gray-900 mb-4">로그인</h1>
								</div>
								
								<form class="user" id="loginForm" method="post" action="/M01F001.do">
									<table class="table table-borderless">
										<tr>
											<td class="text-right" style="vertical-align: middle;">
												<label for="memberId">아이디</label>
											</td>
											<td><input type="email" class="form-control form-control-user" id="memberId" name ="memberId" placeholder="아이디를 입력해주세요"></td>
										</tr>
										<tr>
											<td class="text-right" style="vertical-align: middle;">
												<label for="memberPwd">비밀번호</label>
											</td>
											<td><input type="password" class="form-control form-control-user" id="memberPwd" name="memberPwd" placeholder="비밀번호를 입력해주세요" onkeyup="fnEnter('btnSubmit')"></td>
										</tr>
									</table>
									<a href="javascript::" class="btn btn-primary btn-user btn-block" id="btnSubmit">로그인 </a>
								</form>
								
								<hr>
								
								<div class="col-lg-12 text-center">
									<span>
										<a class="small mr-5" href="javascript::" id="findId">아이디 찾기</a>
										<a class="small" href="javascript::" id="findPwd">비밀번호 찾기</a>
									</span>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
