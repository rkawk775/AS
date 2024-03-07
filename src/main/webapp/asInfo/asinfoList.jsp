<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>예약 확인 페이지</title>
<link rel="stylesheet" type="text/css" href="css/reservation.css">
</head>
<body>
	<div id="wrap" align="center">
		<h1>예약 확인 리스트</h1>
		<table class="list">
		    <tr>
		        <td colspan="6" style="border: white; text-align: right;"><a
				href="asWrite.do">예약신청</a></td>
			</tr>
			<tr>
				<th>AS품목</th>
				<th>날짜</th>
				<th>시간</th>
				<th>이름</th>
				<th>예약수정</th>
				<th>예약삭제</th>
			</tr>
			<c:forEach var="asinfoList" items="${asinfoList}">
			    <input type="hidden" name="res_id" value="${asinfoList.res_id}">
				<tr class="asinfoList" align="center">
					<td>${asinfoList.asitem}</td>
					<td>${asinfoList.res_date}</td>
					<td>${asinfoList.res_time}</td>
					<td>${asinfoList.name}</td>
					<td><a href="asinfoUpdate.do?res_id=${asinfoList.res_id}">예약수정</a></td>
					<td><a href="asinfoDelete.do?res_id=${asinfoList.res_id}">예약삭제</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>