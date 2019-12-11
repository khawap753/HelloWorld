<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	어플 :${ applicationScope.auth }<br>
	<!-- el 태그로 컨텍스트 경로 얻어오는 방법 -->
	${ pageContext.request.contextPath }<br>
</body>
</html>