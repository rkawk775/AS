<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/movie.css">
</head>
<body>
<div id="wrap" align="center">
	<h1>리스트</h1>
	<table class="list">
		<tr>
			<td colspan="6" style="border:white; text-align:right">
			<a href="movieWrite.do">정보 등록</a>
		</tr>
		<tr>
			<th>제목</th><th>감독</th><th>배우</th><th>가격</th><th>수정</th><th>삭제</th>
		</tr>
		<c:forEach var="movie" items="${movieList}">
			<tr class="record">
				<td>${movie.title}</td>
				<td>${movie.drector}</td>
				<td>${movie.actor}</td>
				<td>${movie.price} 원</td>
				<td><a href="movieUpdate.do?code=${movie.code}">상품수정</a></td>
				<td><a href="movieDelete.do?code=${movie.code}">상품삭제</a></td>
			</tr>
		</c:forEach>
	</table>

</div>
</body>
</html>