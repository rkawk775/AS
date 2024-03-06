<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/join.css">
</head>
<body>
<h4>회원 가입</h4>
<form method="post" name="frm" action="join.do">
	<div class="group">
		 <label for="user" class="label">User Name</label>
         <input id="user" type="name" class="input">
    </div>
    <div class="group">
	     <label for="email" class="label">Email Address</label>
         <input id="email" type="email" class="input">
    </div>
    <div class="group">
         <label for="pw" class="label">Password</label>
         <input id="w" type="password" class="input" data-type="password">
    </div>
    <div class="group">
         <label for="pw" class="label">Repeat Password</label>
         <input id="pw" name="pw_check" type="password" class="input" data-type="password">
    </div>
    <div class="group">
         <label for="phone" class="label">Phone</label>
         <input id="phone" type="text" class="input">
    </div>
	<div class="group">
         <input type="submit" class="button" value="Sign Up">
         <input type="reset" class="button" value="cancel">
    </div>
</form>
</body>
</html>