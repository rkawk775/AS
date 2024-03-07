<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>${member}</h1>
<c:forEach var="mem" items="${member}">
<a href="application.do?res_id=2">예약 신청</a>
</c:forEach>
<br>
<form action="change.do" method="post">
<input type="submit" value="예약 변경">
</form>
<br>
<form action="check.do" method="post">
<input type="submit" value="예약 조회">
</form>
 <table>
 	<th>연결 확인</th>
 	<tr>
 		<td>${mamership.name }</td>
 	</tr>
 </table>
</body>
</html>