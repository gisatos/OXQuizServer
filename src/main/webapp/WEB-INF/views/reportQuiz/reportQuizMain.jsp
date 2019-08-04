<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@include file="../header.jsp"%>
<script>
	function checkAll(){
		if($("#allCheck").is(':checked')){
			$("input[name=quizId]").prop("checked", true);
		} else {
			$("input[name=quizId]").prop("checked", false);
		}
	}
	
	function submitC(choice){
		var theForm = document.submitForm;
		if(choice == "1"){
			theForm.action = "reportToZero";
		} else if (choice == "2"){
			theForm.action = "deleteQuiz";
		} else if (choice == "3"){
			theForm.action = "toggleQuiz";
		}
		theForm.submit();
	}
</script>
<form method="post" name="submitForm">
<table border="1" style="margin-left: auto; margin-right: auto; text-align: center;">
	<tr><td>퀴즈</td><td>정답</td><td>등록자</td><td>신고</td><td>신고유형(정답 틀림)</td><td>신고유형(문제 부적절)</td><td>신고유형(기타)</td>
	<td><input type="checkbox" id="allCheck" onclick="checkAll();"></td></tr>
	<c:forEach var="rq" items="${rqList }" varStatus="st">
	<tr><td>${rq.quiz }</td><td>${rq.answer }</td><td>${rq.m_id }</td><td>${rq.r }</td>
	<td>${rTypeList[st.index].wrongAnswer }</td><td>${rTypeList[st.index].unAcceptable }</td><td>${rTypeList[st.index].etc }</td>
	<td><input type="checkbox" value="${rq.id }" name="quizId"></td></tr>
	</c:forEach>
	<tr><td colspan="8"><input type="button" value="신고 초기화" onclick="submitC(1);">
<input type="button" value="문제 삭제하기" onclick="submitC(2);">
<input type="button" value="문제 정답 스위치" onclick="submitC(3);"></td></tr>
</table>

</form>
<%@include file="../footer.jsp"%>