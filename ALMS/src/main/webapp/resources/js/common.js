

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
})


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
function isValid(formId,excludeId)
{
	var  cnt = 0;
	
	$("#"+formId).find("input").each(function(){
		var inputId = $(this).attr("id");		
		var inputVal = $(this).val();
		var labelNm = $("label[for='"+inputId+"']").text();
		
		if(inputId == excludeId)
		{
			cnt = 0;
		}else
		{
			if(isNull(inputVal))
			{
				$(this).val("");
				
				$("#valid_"+inputId).text(labelNm+"을(를) 입력해주세요.");
				$("#"+inputId).removeClass("is-valid");
				$("#"+inputId).addClass("is-invalid");
				
				cnt ++;
			}else
			{
				$("#valid_"+inputId).text("");
				$("#"+inputId).removeClass("is-invalid");
				$("#"+inputId).addClass("is-valid");
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
 * @param title : 제목
 * @param conts : 내용
 * @param confirmUrl : 확인버튼 클릭 시 이동할 url
 * @returns
 * @Desc
 *  - modal 창 띄우기
 * 
 */
function ModalShow (title, conts, confirmUrl)
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

/**
 * @param flag : error, info 등 
 * @param msg : 내용
 * @returns
 * @Desc
 *  - alert 띄우기
 * 
 */
function cmAlert(flag, msg)
{
	swal(msg,"",flag,{ closeOnClickOutside: false});
}
