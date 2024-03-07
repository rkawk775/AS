<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<script type="text/javascript" src="script/login.js"></script>
</head>
<body>
<form method="post" name="loginfrm" action="login.do">
<h1 align="center">로그인</h1>
<table align="center">
	<tr>
		<td>이메일</td>
		<td><input type="text" name="email"></td>
	</tr>
	<tr>
		<td>비밀번호</td>
		<td><input type="password" name="pw"></td>
	</tr>
	<tr>
		<td colspan="2" align="center">
			<input type="radio" name="admin" value="0">관리자 &nbsp; &nbsp;
			<input type="radio" name="admin" value="1">일반회원
		</td>
	</tr>
	<tr>
		<td colspan="2" align="center">
			<input type="button" value="회원가입" onclick="location.href='join.do'"> &nbsp; &nbsp;
			<input type="submit" value="로그인" onclick="return loginCheck()">
		</td>
	</tr>
	<tr>
		<td colspan="2">${message}</td>
	</tr>
</table>
</form>
</body>
</html>