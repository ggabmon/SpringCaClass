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
	$("#updateBtn").on("click", function(){
		 //input 값 변수선언
		 var memberId = $("#memberId").val();
         var password = $("#password").val();
         var name = $("#name").val();
         
         //유효성 검사
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
             $("#memberUpdateForm").submit(); // 실제 서버로 폼을 제출합니다.
         }
	});
});
</script>
<meta charset="UTF-8">
<title>회원 정보 수정</title>
</head>
<body>
	<h2>회원 정보 수정 페이지</h2>
	<form action="${cPath}/member/update" method="post" id="memberUpdateForm">
		<input type="hidden" name="no" value="${member.no }">
		<p>
			<label for="memberId">아이디</label>
			<input type="text" name="memberId" id="memberId" required="required" value="${member.memberid}">
		</p>
		<p>
			<label for="password">비밀번호</label>
			<input type="password" name="password" id="password" required="required" value="${member.password}">
		</p>
		<p>
			<label for="name">이름</label>
			<input type="text" name="name" id="name" required="required" value="${member.name}">
		</p>
		<p>
			<button type="button" id="updateBtn">정보수정하기</button>
		</p>
	</form>
</body>
</html>