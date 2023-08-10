<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="cPath" value="<%=request.getContextPath()%>"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 불러오기</title>
</head>
<body>
<h2>회원 상세 조회</h2>

<table border="1">
	<tbody>
		<tr>
			<td>회원번호</td><td>${member.no }</td>
		</tr>
		<tr>
			<td>아이디</td><td>${member.memberid }</td>
		</tr>
		<tr>
			<td>비밀번호</td><td>${member.password }</td>		
		</tr>
		<tr>
			<td>이름</td><td>${member.name }</td>
		
		</tr>
		<tr>
			<td>가입일</td><td>${member.regdate }</td>
		</tr>
		<tr>
			<td>가입일 형식</td><td><fmt:formatDate value="${member.regdate }" pattern="YY-MM-DD"/></td>
		</tr>
		<tr>
			<td>isshow</td><td>${member.isshow }</td>
		</tr>
		<tr>
			<td colspan="2">
			<a href="${cPath}/member/list?pageNo=1">목록보기</a>
			<a href="${cPath}/member/modify?memberId=${member.memberid}">수정(수정 폼 보여줄것)</a>
			<a href="${cPath}/member/delete?no=${member.no}">삭제</a>
		</tr>
	</tbody>
</table>


</body>
</html>