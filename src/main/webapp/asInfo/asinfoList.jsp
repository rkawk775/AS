<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="asinfoHeader.jsp" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>예약확인 페이지</title>
<link rel="stylesheet" type="text/css" href="css/asinfo.css">
</head>
<br>
<br>
<body>
	<div id="wrap" align="center">
		<h1 id="check">예약 확인 리스트</h1>
		<table class="list">
			<tr>
				<th>AS품목</th>
				<td><input type="text" name="asitem" value="${asinfoList.asitem}"
					    readonly></td>
			</tr>
			<tr>	
				<th>날짜</th>
				<td><input type="text" name="res_date" value="${asinfoList.res_date}"
						readonly></td>
			</tr>
			<tr>	
				<th>시간</th>
				<td><input type="text" name="res_time"
						value="${asinfoList.res_time}" readonly></td>
			</tr>
			<tr>	
				<th>이름</th>
				<td><input type="text" name="res_name"
						value="${asinfoList.name}" readonly></td>			
			</tr>		
			<tr>	
				<th>예약번호</th>
				<td><input type="text" name="res_id"
						value="${asinfoList.res_id}" readonly></td>						
			</tr>
		</table>
		<table id="cldelete">			
			<tr class="asinfoList" align="center">
				<td><input type="button" id="button"
				value="예약삭제" onclick="location.href='asinfoDelete.do?res_id=${asinfoList.res_id}'"></td>
			</tr>
		</table>
	</div>
</body>
</html>