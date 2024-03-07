<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>예약 관리 페이지</title>
<link rel="stylesheet" type="text/css" href="css/reservation.css">
<script type="text/javascript">
    function confirmDelete(name) {
        return confirm("정말 삭제하겠습니까?");
    }
</script>
</head>
<body>
    <div id="wrap" align="center">
        <h1>예약 관리 리스트</h1>
        <form id="searchForm" action="reservationList.do" method="post" name="frm">
            예약자 이름을 입력하시오: <input type="text" name="textSearch" size="20">
            <input type="submit" value="검색">
	        <table class="list">
	            <tr>
	                <th>AS품목</th><th>날짜</th><th>시간</th><th>예약자이름</th><th>예약번호</th><th>전화번호</th><th>이메일</th><th>예약 수정</th><th>예약 삭제</th>
	            </tr>
	            <c:forEach var="reservation" items="${reservationList}">
	                <tr class="record" align="center">
	                    <td>${reservation.asitem}</td>
	                    <td>${reservation.res_date}</td>
	                    <td>${reservation.res_time}</td>
	                    <td>${reservation.name}</td>
	                    <td>${reservation.res_id}</td>
	                    <td>${reservation.membership.phone}</td>
	                    <td>${reservation.membership.email}</td>
	                    <td><a href="reservationUpdate.do?code=${reservation.name}">예약 수정</a></td>
	                    <td><a href="#" onclick="return confirmDelete('${reservation.name}');">예약 삭제</a></td>
	                </tr>
	            </c:forEach>
	        </table>
        </form>
    </div>
</body>
</html>