<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html>
<head>
	<title>Home</title>
</head>
<body>
<c:if test="${not empty name}">
<h1>
	${name}
</h1>
<P>  The time on the server is ${serverTime}. </P>
</c:if>
<c:if test="${empty name}">
이름이 없어...
</c:if>
</body>
</html>
