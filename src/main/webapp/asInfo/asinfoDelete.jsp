<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="asinfoHeader.jsp" %>	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>예약정보 삭제</title>
<link rel="stylesheet" type="text/css" href="css/asinfo.css">
</head>
<br>
<br>
<body>
	<div id="delete" align="center">
		<h1 id="check">예약삭제</h1>
		<br>
		<form method="post" action="asinfoDelete.do">
			<table>
				<tr>
					<th>AS품목</th>
					<td><input type="text" name="asitem" value="${asinfoDelete.asitem}"
					    readonly></td>
				</tr>
				<tr>
					<th>날짜</th>
					<td><input type="text" name="res_date" value="${asinfoDelete.res_date}"
						readonly></td>
				</tr>
				<tr>
					<th>시간</th>
					<td><input type="text" name="res_time"
						value="${asinfoDelete.res_time}" readonly></td>
				</tr>
				<tr>
					<th>이름</th>
					<td><input type="text" name="res_name"
						value="${asinfoDelete.name}" readonly></td>
				</tr>
				<tr>
					<th>예약번호</th>
					<td><input type="text" name="res_id"
						value="${asinfoDelete.res_id}" readonly></td>
				</tr>			
			</table>
			<h3>삭제하면 복구할수 없습니다. 신중히 선택해주세요.</h3>
			<table id="cldelete">
			    <tr>
			        <td><input type="submit" value="삭제"  id="button" onclick="return deletecheck()">
			            <input type="button" value="목록" onclick="location.href='asinfoList.do'" id="button"></td>
			    </tr>
			</table>
		</form>
	</div>
</body>
</html>