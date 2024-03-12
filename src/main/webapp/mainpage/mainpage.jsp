<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="mainHeader.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/mainpage.css">
</head>
<body>
<div id="content">
<c:forEach var="mem" items="${mem}">
<h3 class="messeage" style="text-align: center;">${mem.name}님 환영합니다</h3>
<h3 class="messeage" style="text-align: center;">${message}</h3>
<span>
<a href="application.do?email=${mem.email}">예약 신청</a>
</span>
<br>


<a href="change.do?email=${mem.email}">예약 변경</a>
<br>
<a href="asinfoList.do?email=${mem.email}">예약 조회</a>
</c:forEach>
</div>

</body>
</html>