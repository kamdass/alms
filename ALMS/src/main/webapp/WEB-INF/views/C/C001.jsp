<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html>

	<head>
<%-- 		<%@ include file="../common/commonTag.jsp" %> --%>
</head>

	<body id="page-top">
	
	  <%-- Page Wrapper --%>
	  <div id="wrapper">
	
	    <%-- START:LEFT MENU========================= --%>
	    <tiles:insertAttribute name="left"/>
	    <%-- END:LEFT MENU ========================== --%>
	
	    <%-- Content Wrapper --%>
	    <div id="content-wrapper" class="d-flex flex-column">
	
	      <%-- Main Content --%>
	      <div id="content">
	
	        <%-- START:HEADER MENU========================= --%>
	        <tiles:insertAttribute name="header"/>
	        <%-- END:HEADER MENU ========================== --%>
	
	        <%-- Begin Page Content --%>
	        <div class="container-fluid">
	
	         <%-- START:body========================= --%>
	         <tiles:insertAttribute name="body"/>
			<%-- END:body=========================== --%>
	        
	        </div>
	        <%-- /.container-fluid --%>
	
	      </div>
	      <%-- End of Main Content --%>
	
	      <%-- Footer --%>
	      <footer class="sticky-footer bg-white">
	        <div class="container my-auto">
	          <div class="copyright text-center my-auto">
	            <span>Copyright &copy; Anyware </span>
	          </div>
	        </div>
	      </footer>
	      <%-- End of Footer --%>
	
	    </div>
	    <%-- End of Content Wrapper --%>
	
	  </div>
	  <%-- End of Page Wrapper --%>
	
	  <%-- Scroll to Top Button--%>
	  <a class="scroll-to-top rounded" href="#page-top">
	    <i class="fas fa-angle-up"></i>
	  </a>
	
	  <%-- Logout Modal--%>
	  <div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
	    <div class="modal-dialog" role="document">
	      <div class="modal-content">
	        <div class="modal-header">
	          <h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
	          <button class="close" type="button" data-dismiss="modal" aria-label="Close">
	            <span aria-hidden="true">×</span>
	          </button>
	        </div>
	        <div class="modal-body">Select "Logout" below if you are ready to end your current session.</div>
	        <div class="modal-footer">
	          <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
	          <a class="btn btn-primary" href="login.html">Logout</a>
	        </div>
	      </div>
	    </div>
	  </div>
	
	
	
	</body>

</html>