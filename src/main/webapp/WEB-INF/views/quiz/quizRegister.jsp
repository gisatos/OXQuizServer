<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@include file="../header.jsp"%>
<script>
	function checkAnswer(){
		var answer = document.getElementsByName("q_answer")[0].value;
		if(answer == 'o' || answer == 'O' || answer == 'x' || answer == 'X'){
			
		} else {
			alert('정답은 O, X(소문자 대문자 구분 없음)만 입력 가능합니다.');
			return false;
		}
	}
</script>

<form action="quizRegister" method="post" style="margin-left: auto; margin-right: auto; text-align: center;">
<table>
<tr><td>문제 : </td><td><textarea rows="1" cols="150" name="quiz"></textarea></td></tr>
<tr><td>정답 : </td><td><input type="text" name="answer"></td></tr>
<tr><td><input type="submit" value="제출" onclick="return checkAnswer()"></td><td><input type="reset" value="초기화"></td></tr>
</table>
</form>
<%@include file="../footer.jsp"%>