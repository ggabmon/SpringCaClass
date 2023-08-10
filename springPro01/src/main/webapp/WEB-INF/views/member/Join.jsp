<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="cPath" value="<%=request.getContextPath()%>"/>
<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.min.js"></script>
<script>
$(document).ready(function(){
	$("#joinBtn").on("click", function(){
		 var memberId = $("#memberId").val();
         var password = $("#password").val();
         var name = $("#name").val();
         
         if (memberId === "" || password === "" || name === "") {
             alert("빈 필드를 채워주세요.");
             if (memberId === "") {
                 $("#memberId").focus();
             } else if (password === "") {
                 $("#password").focus();
             } else {
                 $("#name").focus();
             }
         } else {
             alert("ok~");
             $("#memberJoinForm").submit(); // 실제 서버로 폼을 제출합니다.
         }
	});
});
</script>
<meta charset="UTF-8">
<title>회원 가입</title>
</head>
<body>
	<h2>회원 가입 페이지</h2>
	<form action="${cPath}/member/join" method="post" id="memberJoinForm">
		<p>
			<label for="memberId">아이디</label>
			<input type="text" name="memberId" id="memberId" required="required">
		</p>
		<p>
			<label for="password">비밀번호</label>
			<input type="password" name="password" id="password"required="required">
		</p>
		<p>
			<label for="name">이름</label>
			<input type="text" name="name" id="name" required="required">
		</p>
		<p>
			<button type="button" id="joinBtn">회원가입하기</button>
		</p>
	</form>
</body>
</html>