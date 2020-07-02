<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%--===============================================
    *Date : 2020. 4. 21.
    *Desc : 마스터코드 목록화면
===============================================--%>



<%--script::START============================================ --%>
<script type="text/javascript">
$(function() {
   
    
    $("#btnSearch").click(function() {
//     	searchValue = $("#searchForm").serialize();
    	searchValue = JSON.stringify($("#searchForm").serializeObject());
    	console.log("searchValue=["+searchValue+"]");
// 		console.log(Object.toJSON(searchValue));
    	$('#table_list').DataTable().ajax.reload();
	})
});
</script>
<%--script::END============================================= --%>



<%--div::START=========================================== --%>

 <h1 class="h3 mb-2 text-gray-800">마스터코드목록</h1>
 
 <p class="mb-4 text-right">HOME - 시스템관리 - 마스터코드</p>
<form name="searchForm" id="searchForm">
	 <div class="mb-12">
	 	<table class="table table-bordered" id="table_search" width="100%" cellspacing="0">
	 
	 		<tr>
		 		<th>코드</th>
		 		<td> 
		 			<input type="text"  class="form-control" name="masterCode" id="masterCode" value="${masterCode}"> 
		 		</td>
		 		
		 		<th>사용여부</th>
		 		<td>
		 			<label class="radio-inline">
					  <input type="radio" name="useYn" id="useY" value="Y"> 예
					</label>
					&nbsp;
					<label class="radio-inline">
					  <input type="radio" name="useYn" id="useN" value="N"> 아니오
					</label>
		 		</td>
	 		</tr>
	 		<tr>
	 			<th>코드명</th>
	 			<td colspan="3"> 
		 			<input type="text"  class="form-control" name="masterCodeNm" id="masterCodeNm" value="${masterCodeNm}"> 
		 		</td>
	 		</tr>
	 	</table>
	 </div>
 </form>
 
 <div class="mb-12 text-right">
 	<button class="btn btn-outline-primary" style="width:10%;" id="btnSearch">
 		검색
 	</button>
 </div>
 
 <br/>
 
 <div class="mb-12">
   <div class="table-responsive">
     <table class="table table-bordered text-center" id="table_list" width="100%" cellspacing="0">
       <thead>
         <tr>
         	<th>번호</th>
           <th>코드</th>
           <th>코드명</th>
           <th>사용여부</th>
           <th>등록자</th>
           <th>등록일시</th>
           <th>수정자</th>
           <th>수정일시</th>
         </tr>
       </thead>
       <tbody>
   			<c:choose>
       			<c:when test="${list.size() <1}">
   					<tr>
       					<td colspan=7>검색결과가 없습니다.</td>
       				</tr>
       			</c:when>
       			<c:otherwise>
       				<c:forEach items="${list}" var="list" varStatus="status">
       					<tr>
	       					<td> ${status.count}</td>
	       					<td> ${list.masterCode}</td>
	       					<td> ${list.masterCodeNm}</td>
	       					<td> ${list.useYn}</td>
	       					<td> ${list.regId}</td>
	       					<td> ${list.regDt}</td>
	       					<td> ${list.updId}</td>
	       					<td> ${list.updDt}</td>
   						</tr>
       				</c:forEach>
       			</c:otherwise>
       		</c:choose>
       </tbody>
     </table>
   </div>
 </div>
  <%--div::END============================================= --%>