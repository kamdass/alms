<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%--===============================================
    *Date : 2020. 4. 21.
    *Desc : header 파일
===============================================--%>



<%--script::START============================================ --%>
<script type="text/javascript">

</script>
<%--script::END============================================= --%>



<%--header:START=========================================== --%>
	
	<%-- Topbar --%>
	<nav class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top">
	
		<%-- MENU:LEFT:START============================= --%>
		<ul class="navbar-nav mr-auto">

			<%-- Nav Item - User Information --%>
			<c:forEach var="idx" begin="1" end="10">
				<li class="nav-item no-arrow">
					<span class="ml-2 d-none d-lg-inline">
						MENU ${idx }
					</span>  
				</li>
			</c:forEach>
	</ul>
	<%-- MENU:LEFT:END============================= --%>
	
	
		<%-- MENU:RIGHT:START============================= --%>
		<ul class="navbar-nav ml-auto">
	
			<%-- Nav Item - User Information --%>
			<li class="nav-item no-arrow">
				<span class="mr-2 d-none d-lg-inline ">
					<small>홍길동 님 반갑습니다.</small> 
				</span>  
			</li>
			
			<li class="nav-item no-arrow">
				<span class="mr-2 d-none d-lg-inline">
					<small>로그아웃</small>
				</span>  
			</li>
			
			<li class="nav-item no-arrow">
				<span class="mr-2 d-none d-lg-inline">
					<small>마이페이지</small>
				</span>  
			</li>
		</ul>
	<%-- MENU:RIGHT:START============================= --%>
	
	</nav>
	
<%--header:::END============================================= --%>