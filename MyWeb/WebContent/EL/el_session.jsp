<%@page import="com.myweb.user.model.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	MemberVO vo = new MemberVO();
	vo.setName("홍길둑");
	
	// 세션 저장
	session.setAttribute("vo", vo);
	session.setAttribute("id", "kkk123");
	
%>
	<a href="el_session_ok.jsp">el 확인 </a>