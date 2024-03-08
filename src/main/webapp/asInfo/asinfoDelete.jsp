<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>예약정보 삭제</title>
<link rel="stylesheet" type="text/css" href="css/asinfo.css">
</head>
<body>
	<div id="delete" align="center">
		<h1>예약삭제</h1>
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
			</table>
			<br>
			<h3>삭제하면 복구할수 없습니다. 신중히 선택해주세요.</h3>
			<br> <input type="hidden" name="res_id" value="${asinfoDelete.res_id}">
			<input type="submit" value="삭제"> <input type="button"
				value="목록" onclick="location.href='asinfoList.do'">
		</form>
	</div>
</body>
</html>