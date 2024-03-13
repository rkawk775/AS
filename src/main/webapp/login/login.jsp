<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/logoinStyle.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css" >
<script type="text/javascript" src="script/login.js"></script>
<script type="text/javascript" src="script/join.js"></script>
</head>
<body>
	<a href="https://www.samsungsvc.co.kr/" class="logo" target="_blank">
	   <strong>SAMSUNG</strong>
	  </a>
	
	  <div class="section">
	    <div class="container">
	      <div class="row full-height justify-content-center">
	        <div class="col-12 text-center align-self-center py-5">
	          <div class="section pb-5 pt-5 pt-sm-2 text-center">
	            <h6 class="mb-0 pb-3" align="center"><span>Log In </span><span>Sign Up</span></h6>
	                  <input class="checkbox" type="checkbox" id="reg-log" name="reg-log"/>
	                  <label for="reg-log"></label>
	            <div class="card-3d-wrap mx-auto">
	              <div class="card-3d-wrapper">
                    <form method="post" name="loginfrm" action="login.do">
	                <div class="card-front">
	                  <div class="center-wrap">
	                    <div class="section text-center">
	                      <h4 class="mb-4 pb-3">Log In</h4>
	                      <div class="form-group">
	                        <input type="text" name="email" class="form-style" placeholder="이메일 입력하세요."  value="${email}">
	                        <i class="input-icon fa-solid fa-envelope"></i>
	                      </div>  
	                      <div class="form-group mt-2">
	                        <input type="password" name="pw" class="form-style" placeholder="비밀번호 입력하세요" autocomplete="off">
	                        <i class="input-icon fa-solid fa-lock"></i>
	                      </div>
	                      <div class="radio-set">
	                      		<input type="radio" name="admin" value="1">관리자 &nbsp; &nbsp;&nbsp; &nbsp;
								<input type="radio" name="admin" value="0">일반회원
	                      </div>
	                      <input type="submit" value="로그인" class="btn mt-4" onclick="return loginCheck()">
	                              <div class="msg"><h2>${message}</h2></div>  
	                        </div>
	                      </div>
	                    </div>
                       </form>
	                  
                    
	                <div class="card-back">
	                <form method="post" name="frm" action="join.do">
	                  <div class="center-wrap">
	                    <div class="section text-center">
	                      <h4 class="mb-4 pb-3">Sign Up</h4>
	                      <div class="form-group">
	                        <input type="text" name="email" class="form-style" placeholder="이메일" autocomplete="off">
	                        <i class="input-icon fa-solid fa-envelope"></i>
	                      </div>  
	                      <div class="form-group mt-2">
	                        <input type="password" name="pw" class="form-style" placeholder="비밀번호" autocomplete="off">
	                         <i class="input-icon fa-solid fa-lock"></i>
	                      </div>  
	                      <div class="form-group mt-2">
	                        <input type="password" name="pw_check" class="form-style" placeholder="비밀번호 중복 확인" autocomplete="off">
	                        <i class="input-icon fa-solid fa-key"></i>
	                      </div>
	                      <div class="form-group mt-2">
	                        <input type="text" name="name" class="form-style" placeholder="이름" autocomplete="off">
	                        <i class="input-icon fa-solid fa-user"></i>
	                      </div>
	                      <div class="form-group mt-2">
	                        <input type="text" name="phone" class="form-style" placeholder="전화번호"  autocomplete="off">
	                        <i class="input-icon fa-solid fa-phone"></i>
	                      </div>
	                      <input type="submit" value="회원가입" class="btn2 mt-4" onclick="return joinCheck()">
	                      <input type="reset" class="btn2 mt-4" value="취소">
	                      		<div class="msg"><h2>${message}</h2></div>  
	                        </div>
	                      </div>
	                      </form>
	                    </div>
	                  </div>
	                </div>
	              </div>
	            </div>
	          </div>
	      </div>
	  </div>

</body>
</html>