<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="cPath" value="<%=request.getContextPath()%>"/>

<div id="logo">
	<a href="${cPath}/main">
		<img width="50px" alt="로고" src="${cPath}/resources/image/logo.png"/>
	</a>
</div>

<div id="head_link">
	<ul>
		<li><a href="#">로그인</a></li>
		<li><a href="#">사이트맵</a></li>
	</ul>
</div>