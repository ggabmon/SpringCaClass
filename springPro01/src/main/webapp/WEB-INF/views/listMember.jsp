<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="cPath" value="<%=request.getContextPath()%>"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 목록을 불러온다</title>
</head>
<body>
<!-- 회원 정보 있을때 -->
<c:if test="${empty memberList}">
회원가입부터 하세요
${pageNo }
</c:if>
<h2>회원목록보기</h2>
<!-- 회원 정보 없을때 -->
<c:if test="${not empty memberList}">
<table border="1">
	<thead>
		<tr>
			<td>회원번호</td>
			<td>아이디</td>
			<td>비밀번호</td>
			<td>이름</td>
			<td>가입일</td>
			<td>isshow</td>
		</tr>
	</thead>
	<tbody>
	
	<c:forEach var="memberList" items="${memberList}">
		<tr>
			<td>${memberList.no }</td>
			<td><a href="${cPath }/member/detail?memberId=${memberList.memberid }">${memberList.memberid }</a></td>
			<td>${memberList.password }</td>		
			<td>${memberList.name }</td>
			<td>${memberList.regdate }</td>
			<td>${memberList.isshow }</td>
		</tr>
	</c:forEach>
	</tbody>
</table>
</c:if>
</body>
</html>
