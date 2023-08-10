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
			<td>${memberList.memberid }</td>
			<td>${memberList.password }</td>		
			<td>${memberList.name }</td>
			<td><fmt:formatDate value="${memberList.regdate }" pattern="YY-MM-DD"/></td>
			<td>${memberList.isshow }</td>
		</tr>
	</c:forEach>
		<tr>
			<td colspan="2">
			<a href="${cPath}/member/list?pageNo=1">목록보기</a>
			<a href="${cPath}/member/modify?memberNo=${member.no}">수정(수정 폼 보여줄것)</a>
			<a href="${cPath}/member/modify?memberNo=${member.no}">삭제</a>
		</tr>
	</tbody>
</table>
</c:if>
</body>
</html>
