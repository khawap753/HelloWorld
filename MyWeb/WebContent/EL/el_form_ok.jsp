<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");

// 	String id = request.getParameter("id");
// 	String pw = request.getParameter("pw");
// 	String name = request.getParameter("name");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	아이디 ${ param.id }<br>
	비밀번호 ${ param.pw }<br>
	이름 ${ param.name }<br>
</body>
</html>