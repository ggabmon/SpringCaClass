<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="cPath" value="<%=request.getContextPath()%>"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>삭제 실패 페이지</title>
</head>
<body>
<h2>삭제에 실패했습니다.</h2>
<a href="${cPath}/member/list">목록으로 돌아가기</a>
</body>
</html>