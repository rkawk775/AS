<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<c:forEach var=" member" items="${member}">
<a href="application.do?email=bbbbb@naver.com">예약 신청</a>

<br>

<a href="change.do?email=bbbbb@naver.com">예약 변경</a>
<br>
<form action="check.do" method="post">
<input type="submit" value="예약 조회">
</form>

 <table>
 	<th>연결 확인</th>
 	<tr>
 		<td>${member}</td>
 	</tr>
 </table>
 </c:forEach>
</body>
</html>