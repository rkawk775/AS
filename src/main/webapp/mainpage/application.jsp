<%@page import="java.util.Calendar"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="mainHeader.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="script/main.js"></script>
<link rel="stylesheet" type="text/css" href="css/application.css">
<link rel="stylesheet" type="text/css" href="css/mainpage.css">
</head>
<body>
<div class="aside" >
<%
    // 현재 날짜 가져오기
    Date currentDate = new Date();

    // SimpleDateFormat을 사용하여 날짜 포맷팅
    SimpleDateFormat simpleDate = new SimpleDateFormat("MM-dd");
    String strDate = simpleDate.format(currentDate);
%>
<div id="back">
<hr>

        <form action="application.do" method="post" name="frm">       
            <div class="asbg op">
               <h2>AS 품목</h2>
            <div class="asitem con">  
                <p class="op2"><input type="checkbox" name="asitem" value="휴대폰" />스마트 폰</p>
                <p class="op2"><input type="checkbox" name="asitem" value="탭" />탭</p>
                <p class="op2"><input type="checkbox" name="asitem" value="워치" />워치</p><br>
            </div>
            </div>
<hr>
            <div class="datebg op">
        
                <h2>날짜 선택</h2>
                
                <div class="date con">
             <div class="hidden">
                    <input type="radio" name="res_date" value="<%=strDate%>">
               </div>   
                    <%
                        // 1부터 5까지 반복하면서 날짜 1일씩 증가시키기
                        for (int i = 1; i <= 5; i++) {
                            // 새로운 Calendar 객체를 사용하여 각 날짜 계산
                            Calendar nextDateCalendar = Calendar.getInstance();
                            nextDateCalendar.setTime(currentDate);
                            nextDateCalendar.add(Calendar.DAY_OF_MONTH, i);

                            Date nextDate = nextDateCalendar.getTime();
                    %>
                            <input type="radio" name="res_date" style="font-size:17px; width:20px;height:20px" value="<%=simpleDate.format(nextDate)%>"><%=simpleDate.format(nextDate)%>
                    <%
                        }
                    %>
                </div>
            </div>
<hr>
<div class="timebg op">

<h2>시간 선택</h2>

<div class="time con">
	<input type="radio" name="res_time" value="13:00" style="font-size:17px; width:20px;height:20px">13:00
	<input type="radio" name="res_time" value="14:00" style="font-size:17px; width:20px;height:20px">14:00
	<input type="radio" name="res_time" value="15:00" style="font-size:17px; width:20px;height:20px">15:00
	<input type="radio" name="res_time" value="16:00" style="font-size:17px; width:20px;height:20px">16:00
	<input type="radio" name="res_time" value="17:00" style="font-size:17px; width:20px;height:20px">17:00
	<input type="radio" name="res_time" value="18:00" style="font-size:17px; width:20px;height:20px">18:00
</div>
</div>
<hr>
<div class="prbg op">
<div class="prflex">
<h2 class="pr2">개인정보 입력</h2>

<div class="pr con">
<h4>이름</h4>
	<input type="text" name="name" value="${mdto.name}" size="20"><br>
<h4>전화번호</h4>
	<input type="text" name="phone" value="${mdto.phone}" size="20"><br>
<h4>이메일</h4>
	<input type="text" name="email" value="${mdto.email}" size="20" readonly><br>
</div>
</div>
<div class ="btn">	
	<input type="radio" name="check"value="a" checked>본인
	<input type="radio" name="check"value="b">대리
</div>	
</div>
<hr>
<input type="hidden" name="hidden" value="${mdto.name}" size="20">
<div class="btn2">
<input type="submit" value="예약하기" onclick="return asCheck()">
<input type="reset" value="취소">
</div>
</form>
</div>
</div>



</body>
</html>