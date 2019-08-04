<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@include file="../header.jsp"%>
<script>
function submitC(){
	var theForm = document.submitForm;
		theForm.action = "deleteTempQuiz";
	theForm.submit();
}
</script>
<form action="quizRegister" method="post" name="submitForm">
<table border="1" style="margin-left: auto; margin-right: auto; text-align: center;">
	<tr><td>번호</td><td>퀴즈 내용</td><td>정답</td><td>등록자</td><td>선택</td></tr>
	<c:forEach items="${tqList }" var="tquizVO">
		<tr><td>${tquizVO.id }</td><td>${tquizVO.quiz }</td>
		<td>${tquizVO.answer }</td><td>${tquizVO.m_id }</td>
		<td><input type="checkbox" name="check" value="${tquizVO.id }"></td></tr>
	</c:forEach>
	<tr><td colspan="5"><input type="submit" value="퀴즈로 등록"><input type="button" value="등록 거부"></td></tr>
</table>
</form>
<%@include file="../footer.jsp"%>