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
	<!-- elseif 구문은 choose 태그로 묶어서 사용한다. -->
	<!-- when 태그는 elseif구문, otherwise는 else구문  -->
	<c:choose>
		<c:when test="${ param.name eq '홍길동' }">
			홍길동 입니다.
		</c:when>
		<c:when test="${ param.name eq '홍길자' }">
			홍길자 입니다.
		</c:when>
		<c:when test="${ param.name eq '이순신' }">
			이순신입니다.
		</c:when>
		<c:otherwise>
			홍길동, 홍길자, 이순신이 아닙니다.
		</c:otherwise>
	</c:choose>
	
	<!-- 나이가 20세 이상이라면 성인 -->
	<!-- 나이가 20세 미만이라면 미자 -->
	<!-- 성인중 이름이 홍길동이면 "성인인데 홍길동이다"-->
	<!-- 성인중 이름이 이순신이면 "성인인데 이순신이다"-->
	<c:choose>
		<c:when test="${ param.age < 20 }">
			미자
		</c:when>
		<c:when test="${ param.age >= 20 }">
			성인
			<c:choose>
				<c:when test="${ param.name eq '홍길동' }">
					성인인데 길동
				</c:when>
				<c:when test="${ param.name eq '이순신' }">
					성인인데 순신
				</c:when>
			</c:choose>
		</c:when>
		
	</c:choose>
		
</body>
</html>