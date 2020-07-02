<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%--===============================================
    *Date : 2020. 6. 17.
    *Desc : 로그인 화면
===============================================--%>

<%--script::START============================================ --%>
<script type="text/javascript">
$(function() {

// console.log(${sessionScope.loginSession});
	
	$("#btnLogin").click(function(){
			$("form").submit();
		});
});
</script>
<%--script::END============================================= --%>

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
								
								<form class="user" method="post" action="/M01F001.do">
									<div class="form-group">
										<input type="email" class="form-control form-control-user" id="memberId" name ="memberId" aria-describedby="emailHelp" placeholder="아이디를 입력해주세요">
										<span class="small">${valid_memberId}</span>
									</div>
									<div class="form-group">
										<input type="password" class="form-control form-control-user" id="memberPwd" name="memberPwd" placeholder="비밀번호를 입력해주세요">
										<span class="small">${valid_memberPwd}</span>
									</div>
									<a href="javascript::" class="btn btn-primary btn-user btn-block" id="btnLogin">로그인 </a>
								</form>
								
								<hr>
								
								<div class="col-lg-12 text-center">
									<span>
										<a class="small mr-5" href="javascript::">아이디 찾기</a>
										<a class="small" href="javascript::">비밀번호 찾기</a>
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
