<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 앞에 무슨 문장이 오든 .test가 오면 다 TestController로 간다 -->
	<!-- 하지만 경로 요청을 통일해서 적어줘야 나중에 문제가 안생긴다. -->
	<a href="../join.test">등록</a> 
	<a href="../update.test">수정</a>
	<a href="/MyWeb/delete.test">삭제</a>
	<a href="http://localhost:8181/MyWeb/add.test">추가</a>
	
	<form action="../abc.test" method="post">
		<input type="submit" value="확인">
	</form>
</body>
</html>