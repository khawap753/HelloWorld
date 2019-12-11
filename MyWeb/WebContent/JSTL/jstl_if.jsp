<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- test에는 반드시 조건이 들어간다 -->
	<c:if test="true">
		무조건 실행되는 문장<br>
	</c:if>
	
	<hr>
	
	<c:if test="${ param.name == '홍길동' }">
		이름은 홍길동 입니다.<br>
	</c:if>
	
	<c:if test="${ param.name eq '이순신' }">
		이름은 이순신 입니다.<br>
	</c:if>
	
	<hr>
	
	<c:if test="${ param.age >= 20 }">
		성인 입니다.<br>
	</c:if>
	<c:if test="${ param.age < 20 }">
		미성년자 입니다.<br>
	</c:if>
</body>
</html>