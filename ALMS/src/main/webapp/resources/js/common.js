
$(function() {
	/**
	 * 숫자와 -만 입력가능함
	 * */
	$(document).on("keyup", "input:text[phoneOnly]", function() {
		var regExp = /[^0-9\-]/gi;
		
		if( regExp.test($(this).val()))
		{
			alert("숫자와 '-'만 입력가능합니다.");
			$(this).val("");
			return false;
		}
	});
	/**
	 * 엔터키 누르면 submit
	 * */
//	$(document).on("keyup", "input[enterSubmit]", function(event) {
//		var keyCode = window.event ? event.keyCode : event.which;
//		
//		if(keyCode == 13)
//		{
//			$("#"+$(this).parents("form").attr("id")).submit();
//		}
//		
//	});
});


/**
 * @param input= $("#test").val(). (test는 예시)
 * @returns
 *  - true : null임
 *  - false : null이 아님
 * @Desc :입력값이 null 인지 체크
 */
function isNull(input)
{
	input = input.replace(/ /gi, '');
	return (input == null || input == "")? true : false;
}

/**
 * @param form : form id명
 * @param excludeId : 유효성검사를 제외할 항목 아이디
 * @returns
 *  -true : 유효성 검사 ok
 *  -false : 유효성 검사 x
 * @Desc
 *  - form validation check
 */
function isValid(form,excludeId)
{
	var  cnt = 0;
	
	$("#"+form).find("input").each(function(){
		var inputId = $(this).attr("id");		
		var inputVal = $("#"+inputId).val();
		var labelNm = $("label[for='"+inputId+"']").text();
		
		if(inputId == excludeId)
		{
			cnt = 0;
		}else
		{
			if(isNull(inputVal))
			{
				$("#"+inputId).val("");
				//alert(labelNm+" 입력값이 없습니다.");
				ModalShow(cnt,"입력 항목 검증 오류", labelNm+" 입력값이 없습니다.", "")
				cnt ++;
			}
		}
	});
	return (cnt ==0)? true : false;
}

/**
 * @param e
 * @returns
 * @Desc
 *  -핸드폰번호 정규식 체크
 */
function fnCheckPhone(e)
{

	var regExp = /[^0-9\-]/;
	
	if ( !regExp.test(e.value)) {

	      alert("숫자, - 만 입력가능합니다.");
	      e.value = "";
	      return false;

	}
}



/**
 * @param id : submit 실행하는 id
 * @returns
 * @Desc
 *  - enter key 누를경우 submit
 * 
 */
function fnEnter(id)
{
	var keyCode = window.event ? event.keyCode : event.which;
	
	if(keyCode == 13)
	{
		$("#"+id).click();
	}
}

/**
 * @param idx : modal 창을 반복할때 사용
 * @param title : 제목
 * @param conts : 내용
 * @param confirmUrl : 확인버튼 클릭 시 이동할 url
 * @returns
 * @Desc
 *  - modal 창 띄우기
 * 
 */
function ModalShow (idx, title, conts, confirmUrl)
{
	$("#modalTitle").text(title);
	$("#modalConts").text(conts);
	
	if(confirmUrl !="")
	{
		$("#modalBtnConfirm").show();
		$("#modalBtnConfirm").attr("href",confirmUrl);
	}else
	{
		$("#modalBtnConfirm").hide();
	}
	
	$("#myModal").attr("id","myModal"+idx);
	
	$("#myModal"+idx).modal({backdrop: 'static', keyboard: false});
}
