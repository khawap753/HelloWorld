<%@page import="com.myweb.user.model.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 화면에 출력
// 	MemberVO vo = (MemberVO)request.getAttribute("vo");
// 	String id = vo.getId();
// 	String pw = vo.getPw();
// 	String name = vo.getName();
// 	String email = vo.getEmail();
// 	String address = vo.getAddress();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	${ vo.id }
	${ vo.pw }
	${ vo.name }
	${ vo.email }
	${ vo.address }
</body>
</html>