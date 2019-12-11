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
	<h2>1 ~ 100 까지 홀수 합</h2>
	<%
	int sum = 0;
	for(int i = 1; i <= 100; i += 2)  {
			sum += i;
	}
	%>
	결과 : <%= sum %><br>
	
	<!-- jstl 변수 선언 c:set태그 사용 -->
	<!-- el 태그를 jstl안에서 사용 가능 -->
	<c:set var="sum" value="0" scope="page"></c:set> <!-- 변수 이름과 값 선언. scope는 기본값이 page -->
	<c:forEach var="i" begin="1" end="100" step="2"> <!-- 자바 구조랑 다를게 없음. -->
		<c:set var="sum" value="${ sum + i }"></c:set> <!-- 위에 선언된 sum에 i를 누적시켜서 다시 sum이라는 변수에 누적시킨다 라는 뜻 -->
	</c:forEach>
	결과 :${ sum }<br>
	결과 :<c:out value="${ sum }"></c:out> <!-- 출력하는 c:out -->
	
	<br>
	
	<h2>구구단 3단을 foreach 구문으로 출력</h2>
	<%-- <c:set var="num" value="0" scope="page"></c:set> --%> <%-- 변수 필요없음 누적 필요없어서 --%>
	<!-- step은 생략하면 기본값 1 -->
	<c:forEach var="i" begin="1" end="9" step="1">
		3 X ${ i } = ${ 3 * i }<br>
	</c:forEach>
	
	<h2>모든 구구단 foreach 구문으로 출력</h2>
	<c:forEach var="i" begin="2" end="9" step="1">
		<c:forEach var="j" begin="1" end="9" step="1">
			${ i } X ${	j } = ${ i * j }<br>
		</c:forEach>
	</c:forEach>
	
	<h2>향상된 포문</h2>
<%-- 	<% int[] arr = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}; %> --%>
<%-- 	<% for(int i : arr) { %> --%>
<%-- 	   <%= i %> --%>
<%-- 	<% } %> --%>

	<c:set var="arr" value="<%= new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10} %>"></c:set>
	<c:forEach var="i" items="${ arr }">
		${ i }
	</c:forEach>
</body>
</html>