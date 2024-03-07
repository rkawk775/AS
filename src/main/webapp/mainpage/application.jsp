<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="script/main.js"></script>
<link rel="stylesheet" type="text/css" href="css/application.css">
</head>
<body>
<%
	Date date = new Date();
	SimpleDateFormat simpleDate = new SimpleDateFormat("MM-dd");
	String strDate = simpleDate.format(date);
%>
<h1>AS 신청하기</h1>
<div class="back">
<div id="bg">
<form action="application.do" method="post" name="frm">
<div class="asop">
<h2>AS 품목</h2>
	<p class="op2"><input type="checkbox" name="asitem" value="phone" />스마트 폰</p>
	<p class="op2"><input type="checkbox" name="asitem" value="tab" />탭</p>
	<p class="op2"><input type="checkbox" name="asitem" value="watch" />워치</p><br>
	
</div>
<div id="bg">
<h2>날짜 선택</h2>
<div class="date">
	<input type="radio" name="res_date" value="1"><%=strDate %>
	<input type="radio" name="res_date" value="2">+2
	<input type="radio" name="res_date" value="3">+3
	<input type="radio" name="res_date" value="4">+4
	<input type="radio" name="res_date" value="5">+5
</div></div>
<div id="bg">
<h2>시간 선택</h2>
<div class="time">
	<input type="radio" name="res_time" value="13:00">13:00
	<input type="radio" name="res_time" value="14:00">14:00
	<input type="radio" name="res_time" value="15:00">15:00
	<input type="radio" name="res_time" value="16:00">16:00
	<input type="radio" name="res_time" value="17:00">17:00
	<input type="radio" name="res_time" value="18:00">18:00
</div>
</div>
<div id="bg">
<h2>개인정보 입력</h2>
<div class="pr">
<h4>이름</h4>
	<input type="text" name="name" value="${mdto.name}" size="20"><br>
<h4>전화번호</h4>
	<input type="text" name="phone" value="${mdto.phone}" size="20"><br>
<h4>이메일</h4>
	<input type="text" name="email" value="${mdto.email}" size="20"><br>
</div>
<div class ="btn">	
	<input type="radio" name="check"value="a" checked>본인
	<input type="radio" name="check"value="b">대리
</div>	
</div>
<input type="hidden" name="hidden" value="${mdto.name}" size="20">
<div class="btn2">
<input type="submit" value="예약하기" onclick="return asCheck()">
<input type="reset" value="취소">
</div>
</form>
</div>
</div>


</body>
</html>