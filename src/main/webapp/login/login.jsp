<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>
<form method="post" name="loginfrm" action="application.do">
<h1 align="center">로그인</h1>
<table align="center" border =1>
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
			<input type="radio" name="관리자" value="0">관리자 &nbsp; &nbsp;
			<input type="radio" name="일반 회원" value="1">일반회원
		</td>
		<td rowspan="3" align="center"><input type="submit" value="로그인"></td>
	</tr>
</table>
</form>
</body>
</html>