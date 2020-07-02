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
   
	var searchValue;
	
	var t = $("#table_list").DataTable({
    	lengthChange: false				<%-- 표시 건수기능 숨기기--%>
    	, searching: false					<%--검색 기능 숨기기--%>
    	, ordering: true						<%--정렬 기능 숨기기--%>
    	, info: false							<%--정보 표시 숨기기--%>
    	, paging: true						<%--페이징 기능 숨기기--%>
    	, pagingType : "full_numbers"	<%--페이징 옵션--%>
    	, serverSide: false					<%--서버 처리 수행 여부--%>
    	
    	, "dom" : 'ft<"col-sm-8"p>'	<%--f : 검색 / t : 테이블 / p : 페이징--%>
    	
    	,  "language":						<%--언어 세팅--%> 
    	{
            "emptyTable": "검색결과가 없습니다.",
            "lengthMenu": "페이지당 _MENU_ 개씩 보기",
            "info": "현재 _START_ - _END_ / _TOTAL_건",
            "infoEmpty": "데이터 없음",
            "infoFiltered": "( _MAX_건의 데이터에서 필터링됨 )",
            "search": "검색: ",
            "zeroRecords": "일치하는 데이터가 없습니다.",
            "loadingRecords": "로딩중...",
            "processing":     "잠시만 기다려 주세요.",
            "paginate": {
                "first" : "처음"
            	, "next": "다음"
                , "previous": "이전"
                , "last" : "끝"
            }
        }
    	,ajax: 									<%--AJAX--%>
    	{
    		"url" : "/system/masterCodeList.do"
    		,"type": "POST"
//         	,"contentType":"application/json"
        		,"dataType":"JSON"
//     		,"data" : JSON.stringify($("#searchForm").serializeObject())
//     		,"data" : $("#searchForm").serializeObject()
    		,"data" : 
    		{
    			"masterCode":$("#masterCode").val()
    			,"masterCodeNm" : $("#masterCodeNm").val()
    		}
    	 }
    	, columns:								<%--컬럼명 세팅--%>
    		[
    			{ data: "masterCode" ,sClass : "text-center"}			<%--마스터코드--%>
    			,{ data: "masterCodeNm" ,sClass : "text-center"}	<%--마스터코드명--%>
    			,{ data: "useYn" ,sClass : "text-center"}					<%--사용여부--%>
    			,{ data: "regId" ,sClass : "text-center"}					<%--등록자--%>
    			,{ data: "regDt" ,sClass : "text-center"}					<%--등록일시--%>
    			,{ data: "updId" ,sClass : "text-center"}					<%--수정자--%>
    			,{ data: "updDt" ,sClass : "text-center"}					<%--수정일시--%>
 	         ]
    });
    
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
     <table class="table table-bordered" id="table_list" width="100%" cellspacing="0">
       <thead class="text-center">
         <tr>
           <th>코드</th>
           <th>코드명</th>
           <th>사용여부</th>
           <th>등록자</th>
           <th>등록일시</th>
           <th>수정자</th>
           <th>수정일시</th>
         </tr>
       </thead>
     </table>
   </div>
 </div>
  <%--div::END============================================= --%>