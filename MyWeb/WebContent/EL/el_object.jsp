<%@page import="com.myweb.user.model.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	MemberVO vo = new MemberVO();
	vo.setId("hhh123");
	vo.setPw("1234");
	vo.setName("lim");
	vo.setEmail("lim123@naver.com");
	vo.setAddress("부산");
	
	// 강제 저장
	request.setAttribute("vo", vo);
	// 포워드 화면 이동
	RequestDispatcher dp = request.getRequestDispatcher("el_object_ok.jsp");
	dp.forward(request, response);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>