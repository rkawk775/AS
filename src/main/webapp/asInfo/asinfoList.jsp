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
	<div id="back" align="center">
		<h1 id="check">예약 확인 리스트</h1>
		<hr width="70%">
		<br>
			<div id="cwitem">
				<h2>AS품목</h2>
				<br>
				<p><input type="text" name="asitem" value="${asinfoList.asitem}"
					    readonly></p>
			</div>
			<hr width="70%">
			<div id="asdate">	
				<h2>날짜</h2>
				<br>
				<p><input type="text" name="res_date" value="${asinfoList.res_date}"
						readonly></p>
			</div>
			<hr width="70%">
			<div id="astime">	
				<h2>시간</h2>
				<br>
				<p><input type="text" name="res_time"
						value="${asinfoList.res_time}" readonly></p>
			</div>
			<hr width="70%">
			<div>	
				<h2>이름</h2>
				<br>
				<p><input type="text" name="res_name"
						value="${asinfoList.name}" readonly></p>			
			</div>
			<hr width="70%">		
			<div>	
				<h2>예약번호</h2>
				<br>
				<p><input type="text" name="res_id"
						value="${asinfoList.res_id}" readonly></p>						
			</div>
			<hr width="70%">
			<h3>${message}</h3>
			<br>
			<br>
		    <div id="cldelete">			
			    <div id="asinfoList" align="center">
				    <input type="button" value="예약삭제" onclick="location.href='asinfoDelete.do?res_id=${asinfoList.res_id}' " id="button">
			    </div>	
	    </div>
	    <br>
	    <br>
	    <br>
	    <br>
	</div>
</body>
</html>