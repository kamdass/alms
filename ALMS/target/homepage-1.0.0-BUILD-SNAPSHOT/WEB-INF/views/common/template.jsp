<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE HTML>
<html>
	<head>
		<title>Anyware HomePage</title>
		<meta http-equiv="content-type" content="text/html; charset=utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<meta name="description" content="" />
		<meta name="keywords" content="" />
		
		<%--icon error --%>
		<link rel="shortcut icon" href="data:image/x-icon;" type="image/x-icon">
		
		<%--Jquery --%>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
		
		<%--bootstrap CDN --%>
		<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
		<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
		<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js" integrity="sha384-6khuMg9gaYr5AxOqhkVIODVIvm9ynTT5J4V1cfthmT+emCG6yVmEZsRHdxlotUnm" crossorigin="anonymous"></script>
		
		<%--css --%>
		<link href="/resources/css/style.css" rel="stylesheet">
	</head>
	
	<body>
		<c:choose>
			<c:when test="${flag == 'error'}">
				<tiles:insertAttribute name="body" />
			</c:when>
			<c:otherwise>
				<div class="wrapper">
					  <div class="header"><tiles:insertAttribute name="header" /></div>
					  <div class="menu"><tiles:insertAttribute name="left" /></div>
					  <div class="body"><tiles:insertAttribute name="body" /></div>
					  <div class="footer"><tiles:insertAttribute name="footer" /></div>
				</div>
			</c:otherwise>
		</c:choose>
	</body>
</html>