<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>예약 관리 리스트</title>
<link rel="stylesheet" type="text/css" href="css/reservation.css">
</head>
<body>
	<div id="wrap" align="center">
		<h1>예약 관리 리스트</h1>
		<table class="list">
			<tr>
				<td colspan="7" style="border: white; text-align: right;">
			</tr>
			<tr>
				<td>AS품목</td><td>날짜</td><td>시간</td><td>예약자이름</td><td>예약번호</td><td>전화번호</td><td>이메일</td>
			</tr>
			<c:forEach var="reservation" items="${reservationList }">
				<tr class="record" align="center">
					<td>${reservation.asitem }</td>
					<td>${reservation.res_date }</td>
					<td>${reservation.res_time }</td>
					<td>${reservation.res_name }</td>
					<td>${reservation.res_id }</td>
					<td>${reservation.phone }</td>
					<td>${reservation.email }</td>
					<td><a href="reservationUpdate.do?code=${reservation.res_id }">예약 수정</a></td>
					<td><a href="reservationDelete.do?code=${reservation.res_id }">예약 삭제</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>