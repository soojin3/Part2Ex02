<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta charset="utf-8">
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>
<h1>
<a href="/board/chart2">차트 보러 가기2</a><br>
<a href="/board/chart">차트 보러 가기</a><br>
<a href="/board/list">목록 보러 가기</a><br>
<a href="/board/register">글 쓰러 가기</a><br>
<a href="/board/rank">랭크 보러 가기</a><br>
<a href="/board/last">최근 글 보러 가기</a><br>
</h1>
</body>
</html>
