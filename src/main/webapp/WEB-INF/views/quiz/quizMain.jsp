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
			theForm.action = "/quiz/reportQuiz/deleteQuiz";
		} else if (choice == "2"){
			theForm.action = "/quiz/reportQuiz/toggleQuiz";
		}
		theForm.submit();
	}
</script>
<form method="post" name="submitForm">
<table border="1" style="margin-left: auto; margin-right: auto; text-align: center;">
	<tr><td>번호</td><td>출제자</td><td>문제</td><td>정답</td>
	<td>카테고리</td><td>정답 수(A)</td><td>총 수(B)</td><td>정답률(A/B)</td>
	<td><input type="checkbox" id="allCheck" onclick="checkAll();"></td></tr>
	<c:forEach items="${qList}" var="q">
		<tr><td>${q.id }</td><td>${q.m_id }</td><td>${q.quiz }</td>
		<td>${q.answer }</td><td>${q.category }</td>
		<td>${q.ans_count }</td><td>${q.count }</td>
		<td><fmt:formatNumber value="${q.ans_count / q.count }" type="percent"/></td>
		<td><input type="checkbox" value="${q.id }" name="quizId"></td>
		</tr>
	</c:forEach>
	<tr><td colspan="9"><input type="button" value="문제 삭제하기" onclick="submitC(1);">
<input type="button" value="문제 정답 스위치" onclick="submitC(2);"></td></tr>
</table>
</form>
<%@include file="../footer.jsp"%>