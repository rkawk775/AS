<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="asinfoHeader.jsp" %>	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>예약정보 삭제</title>
<link rel="stylesheet" type="text/css" href="css/asinfo.css">
<script type="text/javascript" src="script/asinfo.js"></script>
</head>
<br>
<br>
<body>
	<div id="back" align="center">
		<hr width="70%">
		<form method="post" action="asinfoDelete.do">
			<div>
				<div>
					<h2>AS품목</h2>
					<p><input type="text" name="asitem" value="${asinfoDelete.asitem}"
					    readonly></p>
				</div>
			</div>
			<hr width="70%">
			<div>
					<h2>날짜</h2>
					<p><input type="text" name="res_date" value="${asinfoDelete.res_date}"
						readonly></p>
			</div>
			<hr width="70%">
			<div>		
					<h2>시간</h2>
					<p><input type="text" name="res_time"
						value="${asinfoDelete.res_time}" readonly></p>
			</div>
			<hr width="70%">
			<div>	
					<h2>이름</h2>
					<p><input type="text" name="res_name"
						value="${asinfoDelete.name}" readonly></p>
			</div>
			<hr width="70%">
			<div>	
					<h2>예약번호</h2>
					<p><input type="text" name="res_id"
						value="${asinfoDelete.res_id}" readonly></p>
			</div>
			<hr width="70%">
			<br>
			<br>				
			<h3>삭제하면 복구할수 없습니다. 신중히 선택해주세요.</h3>
			<br>
			<div id="cldelete">
			        <p><input type="submit" value="삭제"  id="button" onclick="return deletecheck()"></p>
			</div>
		</form>
	</div>
</body>
</html>