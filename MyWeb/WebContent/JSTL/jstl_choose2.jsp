<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- choose 태그 사용
	90점 이상 A 95이상 A++
	80점 이상 B
	70점 이상 C
	나머지 F 
	나머지는 A로 중점 if구문 써서 처리 -->
	<c:choose>
		<c:when test="${ param.point >= 90 }">
			<c:choose>
				<c:when test="${ param.point >= 95 }">
					A++<br>
				</c:when>
				<c:otherwise>
					A<br>
				</c:otherwise>
			</c:choose>
		</c:when>
		<c:when test="${ param.point >= 80 }">
			B<br>
		</c:when>
		<c:when test="${ param.point >= 70 }">
			C<br>
		</c:when>
		<c:otherwise>
			F<br>
		</c:otherwise>	
	</c:choose>
</body>
</html>