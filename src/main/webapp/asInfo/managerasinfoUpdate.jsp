<%@page import="java.util.Calendar"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="managerUpdateHeader.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>예약정보 변경</title>
<link rel="stylesheet" type="text/css" href="css/managerReservation.css">
</head>
<body>
	<%
	    // 현재 날짜 가져오기
	    Date currentDate = new Date();
	
	    // SimpleDateFormat을 사용하여 날짜 포맷팅
	    SimpleDateFormat simpleDate = new SimpleDateFormat("MM-dd");
	    String strDate = simpleDate.format(currentDate);
	%>
	<div id="wrap" align="center">
        <h1>예약 수정</h1>
		<div id="inside" align="center">
	        <form method="post" action="managerasinfoUpdate.do">
	            <table>
	                <tr>
	                    <th>AS품목</th>
	                    <td><input type="text" name="asitem" value="${rdto.asitem}" readonly></td>
	                </tr>
	                <tr>
	                    <th>날짜</th>
	                    <td><input type="text" name="res_date" 
	                        value="${rdto.res_date}"></td>
	                </tr>
	                <tr>
	                    <th>시간</th>
	                    <td><input type="text" name="res_time"
	                        value="${rdto.res_time}"></td>
	                </tr>
	                <tr>
	                    <th>이름</th>
	                    <td><input type="text" name="name"
	                        value="${rdto.name}" readonly></td>
	                </tr>   
	                <tr>
	                    <th>예약번호</th>
	                    <td><input type="text" name="res_id"
	                        value="${rdto.res_id}" readonly></td>
	                </tr>       
	            </table>
	            <br>
	        </form>
     	</div>
        <input type="submit" value="변경">
        <input type="button" value="목록" onclick="location.href='reservationList.do'">
    </div>
</body>
</html>
<%@ include file="managerUpdateFooter.jsp" %>