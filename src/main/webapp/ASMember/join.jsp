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
    	<td><input type="email" name="email"></td>
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
    	<td><input type="text" name="name"><td>
    </tr>
    <tr>
    	<td>전화번호</td>
    	<td><input type="text" name="phone"><td>
    </tr>
    <tr>
    	<td colspan="2" align="center">
    		<input type="submit" class="button" value="가입" onclick="return joinCheck()">
    		&nbsp;&nbsp;&nbsp;&nbsp;
        	<input type="reset" class="button" value="취소">
        <td>
    </tr>
</table>
</form>
</body>
</html>