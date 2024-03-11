<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>예약확인 페이지</title>
<link rel="stylesheet" type="text/css" href="css/asinfo.css">
</head>
<body>
	<div id="wrap" align="center">
		<h1>예약 확인 리스트</h1>
		<form action="managerasinfoList.do" method="post" name="frm">
			<table class="list">
				<tr>
				    <th>AS품목</th>
				    <td><input type="text" name="asitem" value="${reservation.asitem}" readonly></td>
				</tr>
				<tr>    
				    <th>날짜</th>
				    <td><input type="text" name="res_date" value="${reservation.res_date}" readonly></td>
				</tr>
				<tr>    
				    <th>시간</th>
				    <td><input type="text" name="res_time" value="${reservation.res_time}" readonly></td>
				</tr>
				<tr>    
				    <th>이름</th>
				    <td><input type="text" name="res_name" value="${reservation.name}" readonly></td>            
				</tr>        
				<tr>    
				    <th>예약번호</th>
				    <td><input type="text" name="res_id" value="${reservation.res_id}" readonly></td>                        
				</tr>
			</table>
		</form>
		<tr class="asinfoList" align="center">		
			<td><input type="button" 
			value="예약수정" onclick="location.href='managerasinfoUpdate.do?res_id=${reservation.res_id}'"></td>
		</tr>
	</div>
</body>
</html>