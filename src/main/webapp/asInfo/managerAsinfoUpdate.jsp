<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>예약정보 변경</title>
<link rel="stylesheet" type="text/css" href="css/asinfo.css">
</head>
<body>
<div id="update" align="center">
		<h1>예약변경</h1>
		<form method="post" action="managerasinfoUpdate.do">
			<table>
				<tr>
					<th>AS품목</th>
					<td><input type="text" name="asitem" value="${reservation.asitem}"
					    readonly></td>
				</tr>
				<tr>
					<th>날짜</th>
					<td><input type="text" name="res_date" 
					    value="${reservation.res_date}"></td>
				</tr>
				<tr>
					<th>시간</th>
					<td><input type="text" name="res_time"
						value="${reservation.res_time}"></td>
				</tr>
				<tr>
					<th>이름</th>
					<td><input type="text" name="res_name"
						value="${reservation.name}" readonly></td>
				</tr>	
				<tr>
					<th>예약번호</th>
					<td><input type="text" name="res_id"
						value="${reservation.res_id}" readonly></td>
				</tr>		
			</table>
			<br>
			<input type="submit" value="변경"> <input type="button"
				value="목록" onclick="location.href='managerasinfoList.do'">
		</form>
	</div>
</body>
</html>