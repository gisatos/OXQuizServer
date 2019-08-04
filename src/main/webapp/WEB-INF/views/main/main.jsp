<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@include file="../header.jsp"%>
<c:if test="${id != null }">
	${id }님이 로그인 하셨습니다.<br>
	<a href="quiz/quizMain">문제 관리</a><br>
	<a href="quiz/quizRegister">문제 등록</a><br>
	<a href="tempQuiz/quizRegister">유저 등록 문제 관리</a><br>
	<a href="reportQuiz/reportQuizMain">신고 문제 관리</a>
</c:if>
<c:if test="${id == null }">
관리자 로그인
<form action="member/login" method="post">
<table style="margin-left: auto; margin-right: auto">
<tr><td>아이디 : </td><td><input type="text" name="id"></td></tr>
<tr><td>비밀번호 : </td><td><input type="password" name="password"></td></tr>
<tr><td><input type="submit" value="로그인"></td><td><input type="reset" value="취소"></td></tr>
</table>
</form>
</c:if>
<%@include file="../footer.jsp"%>