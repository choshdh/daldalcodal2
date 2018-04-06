<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:choose>
	<c:when test="${authUser ==null }">로그인</c:when>
	<c:otherwise>로그아웃</c:otherwise>
</c:choose>
<h1>main화면입니다.</h1>
<a href="${pageContext.request.contextPath}/user/loginform">로그인화면으로 이동</a><br>
<a href="${pageContext.request.contextPath}/user/joinform">회원가입화면으로 이동</a><br>
<a href="${pageContext.request.contextPath}/writeform">작성란화면으로 이동</a><br>
</body>
</html>