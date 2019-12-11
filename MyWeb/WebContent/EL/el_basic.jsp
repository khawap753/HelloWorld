<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%= 3 + 5 %><br>
	<%= 3 > 5 %><br>
	<%= 4 % 2 == 0 ? "참" : "거짓" %><br>
	<%= 1 > 2 || 2 > 1 %><br>
	<%= true && false %><br>
	
	<hr>
	${ 3 + 5 }
	${ 3 > 5 }
	${ 4 % 2 == 0 ? "같음" : "다름" }<br>
	${ 1 > 2 || 2 > 1 }
	${ 1 > 2 or 2 > 1 }<br>
	
	${ '홍길동' == '홍길동' }
	${ '홍길동' eq '홍길동' }<br>
	
	${ 1 < 2 && 1 > 2 }
	${ 1 < 2 and 1 > 2 }<br>
	 
	
</body>
</html>