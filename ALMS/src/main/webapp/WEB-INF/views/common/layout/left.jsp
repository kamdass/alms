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



<%--LEFT::START=========================================== --%>
	
	<%-- Sidebar --%>
	<ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">

		<%-- 로고 --%>
		<a class="sidebar-brand d-flex align-items-center justify-content-center" href="index.html">
			<div class="sidebar-brand-icon rotate-n-15"></div>
			<div class="sidebar-brand-text mx-3"> 로고 </div>
		</a>

		<%-- 선 --%>
		<hr class="sidebar-divider my-0">

		<%--메뉴 --%>
		<c:forEach begin="1" end="5" var="idx">
		
		<li class="nav-item">
			<a class="nav-link" href="#" data-toggle="collapse" data-target="#collapsePages_${idx}" aria-expanded="true" aria-controls="collapsePages_${idx}"> 
				<i class="fas fa-fw fa-folder"></i> 
				<span>MENU${idx}</span>
			</a>
			<div id="collapsePages_${idx}" class="collapse" aria-labelledby="headingPages" data-parent="#accordionSidebar">
				<div class="bg-white py-2 collapse-inner rounded">
					<a class="collapse-item" href="login.html">Login</a> <a class="collapse-item" href="register.html">RegisteSSSSSSSSSSr</a> 
					<a class="collapse-item" href="forgot-password.html">Forgot Password</a>
					<a class="collapse-item active" href="blank.html">Blank Page</a>
				</div>
			</div>
		</li>
		
		<%-- 선 --%>
		<hr class="sidebar-divider">
		
		</c:forEach>
	</ul>
	<%-- End of Sidebar --%>
	
<%--LEFT::END============================================= --%>