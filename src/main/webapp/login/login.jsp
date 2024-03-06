<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="css/reservation.css">
<title>로그인</title>
</head>
<body>
<form action="" method="post">
<h1 align="center">로그인</h1>
<table align="center" >
	<tr>
		<td>이메일</td>
		<td><input type="text" name="email"></td>
		<td rowspan="3"><input type="submit" value="로그인"></td>
	</tr>
	<tr>
		<td>비밀번호</td>
		<td><input type="password" name="pw"></td>
	</tr>
	<tr>
		<td>
			<input type="radio" name="관리자" value="">
		</td>
	</tr>
</table>
</form>
</body>
</html>