<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="script/join.js"></script>
</head>
<body>
<form method="post" name="frm" action="join.do">
<h1 align="center">회원 가입</h4>
<table align="center">
    <tr>
    	<td>이메일</td>
    	<td><input type="email" name="email" placeholder="deawoo@gmail.com"></td>
    </tr>
    <tr>
    	<td>비밀번호</td>
    	<td><input type="password" name="pw"><td>
    </tr>
    <tr>
    	<td>비밀번호 확인</td>
    	<td><input type="password" name="pw_check"><td>
    </tr>
    <tr>
    	<td>이름</td>
    	<td><input type="text" name="name" placeholder="홍길동"><td>
    </tr>
    <tr>
    	<td>전화번호</td>
    	<td><input type="text" name="phone" placeholder="010-xxxx-xxxx"><td>
    </tr>
    <tr>
    	<td colspan="2" align="center">
    		<input type="submit" value="가입" onclick="return joinCheck()">
    		&nbsp;&nbsp;&nbsp;&nbsp;
        	<input type="button" value="취소" onclick="location.href='login.do'">
        <td>
    </tr>
    <tr>
		<td colspan="2">${message }</td>
	</tr>
</table>
</form>
</body>
</html>