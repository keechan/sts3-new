<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@taglib  uri="http://java.sun.com/jstl/core_rt"  prefix="c" %>   
<c:set var="path" value="${pageContext.request.contextPath}" scope="session" />
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="${path}/include/top.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<header>
 2023 쇼핑몰관리 ver1.0
</header>
<nav>
&emsp;<a href=boardGetBoardList.do>게시판 조회</a>
&emsp;<a href=boardWrite.do>글쓰기</a>
<c:if test="${'ADMIN' eq sessionName}">
&emsp;<a href=examList.do>성적처리목록보기</a>
&emsp;<a href=examInsert.do>성적입력</a>
&emsp;<a href=psdList.do>자료목록보기</a>
</c:if>
<c:if test="${not empty sessionName}">
&emsp;<a href=psdInsert.do>자료실입력</a>
&emsp;<a href=productList.do>상품목록보기</a>
&emsp;<a href=productInsert.do>상품입력</a>
&emsp;<a href=memberForm.do>회원등록</a>
&emsp;<a href=memberList.do>회원목록보기</a>
</c:if>
<c:if test="${empty sessionName}">
	&emsp;<a href=memberLogin.do>로그인</a>
</c:if>
<c:if test="${not empty sessionName}">
	&emsp;<a href=memberLogout.do>${sessionName}님 (로그아웃)</a>
</c:if>
&emsp;&emsp;<a href=index.jsp>홈으로</a>
</nav>