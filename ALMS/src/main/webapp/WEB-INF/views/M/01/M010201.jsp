<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="msg" %>

<%--===============================================
    *Date : 2020. 6. 19.
    *Desc : 아이디, 비밀번호 찾기 화면
===============================================--%>

<%--script::START============================================ --%>
<script type="text/javascript">
$(function() {
	
	<%--찾기 버튼 클릭--%>
	$("#btnSubmit").click(function(){

		var flag = "${flag}";
		if(isValid("frmSubmit",(flag == "1"? "memberId" : "")))
		{
	        var param = $("#frmSubmit").serialize() ;
	 
	        $.ajax({
	            type : "post"
	            , url : "/M01F002.do"
	            , data : param
	            , dataType : "json"
	            ,beforeSend:function()
	            {
		            $('.wrap-loading').removeClass('display-none');
	             }
	            ,complete:function()
	            {	
		            $('.wrap-loading').addClass('display-none');
	             }
	            , error: function(xhr, status, error)
	            {
					var msg = "<msg:message code='error.ajax.fail'/>";
					console.log("ajax::error::status=["+status+"] error=["+error+"]"); 
					cmAlert("error",msg);
	                return false;
	            }
	            , success : function(result)
	            {
					var mailResultFlag = result.mailResultFlag;
					var msg = result.msg;
					var title = ($("#flag").val() == 1)? "아이디 찾기 " : "비밀번호 찾기";
					var msgParam = ($("#flag").val() == 1)? "비밀번호 찾기 " : "아이디 찾기";
					
					confirm(title,msg+"<msg:message code='confirm.move' arguments='로그인'/>","/M010101.do");

	            }
	        });
		}
	});

	<%--로그인화면으로 이동--%>
	$("#goLogin").click(function(){
		$(this).attr("href","/M010101.do");
		});

	<%--비밀번호 찾기 클릭 시--%>
	$("#findPwd").click(function(){
		$("#findFlag").val(2);
		$("#frmSubmit").attr("action","/M010201.do");
		$("#frmSubmit").submit();
	});
});
</script>
<%--script::END============================================= --%>
<div class="wrap-loading display-none">
    <div><img src="/resources/images/loading.gif" /></div>
</div>

<div class="container">
	<div class="row justify-content-center">
		<div class="col-xl-10 col-lg-12 col-md-9">
			<div class="card o-hidden border-0 shadow-lg my-5">
				<div class="card-body p-0">
					<div class="row">
						<div class="col-lg-6 d-none d-lg-block bg-password-image"></div>
						<div class="col-lg-6">
							<div class="p-5">
								<div class="text-center">
									<h1 class="h4 text-gray-900 mb-2" id=findTitle>
										<c:choose>
											<c:when test="${flag eq 1}"> 아이디 </c:when>
											<c:otherwise> 비밀번호 </c:otherwise>
										</c:choose>
										찾기
									</h1>
								</div>
								<form class="user" id="frmSubmit" name="frmSubmit" method="post" action="/M01F002.do">
									<input type="hidden" id="findFlag" name="findFlag" value=""/>	<%--아이디찾기, 비밀번호 찾기 구분값 --%>
									<input type="hidden" name="flag" id="flag" value="${flag}">	<%--아이디 찾기인지, 비밀번호찾기인지 구분값 --%>
									<table class="table table-borderless">
										
										<tr>
											<td class="text-right" style="vertical-align: middle;">
												<label for="memberNm">이름</label>
											</td>
											<td>
												<input type="text" class="form-control form-control-user" id="memberNm" name="memberNm"  placeholder="홍길동">
												<small  id="valid_memberNm" class="text-center"></small>
											</td>
										</tr>
										
										<tr>
											<td class="text-right" style="vertical-align: middle;">
												<label for="memberPhone">핸드폰번호</label>
											</td>
											<td>
												<input type="text" class="form-control form-control-user" id="memberPhone" name="memberPhone" maxlength="13" phoneOnly onkeyup="fnEnter('btnSubmit')" placeholder="010-0000-0000">
												<small  id="valid_memberPhone" class="text-center"></small>
											</td>
										</tr>
										
										<c:if test="${flag eq 2 }">
											<tr>
												<td class="text-right" style="vertical-align: middle;">
													<label for="memberId">아이디</label>
												</td>
												<td>
													<input type="text" class="form-control form-control-user" id="memberId" name="memberId" onkeyup="fnEnter('btnSubmit')" placeholder="example@gmail.com">
													<small  id="valid_memberId" class="text-center"></small>
												</td>
											</tr>
										</c:if>
									</table>
									<a href="javascript::" id="btnSubmit" class="btn btn-primary btn-user btn-block">찾기 </a>
								</form>
								<hr>
								<div class="text-center">
									<a class="small <c:if test='${flag eq 1 }'>mr-5</c:if>" href="javascript::" id="goLogin">로그인 화면으로 이동</a>
									<c:if test="${flag eq 1 }">
										<a class="small" href="javascript::" id="findPwd">비밀번호 찾기</a>
									</c:if>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>