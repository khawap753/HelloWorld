<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="brand">My Web</div>
<div class="address-bar">Welcome to MyWorld</div>

<nav class="navbar navbar-default" role="navigation">
	<div class="container">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#bs-example-navbar-collapse-1">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>

			<a class="navbar-brand" href="/hong">My First Web</a>
		</div>


		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">

				<li><a href="/MyWeb">HOME</a></li>
				<li><a href="/MyWeb/member/member.jsp">Member</a></li>
				<li><a href="/MyWeb/board/list.board">BOARD</a></li>
<%-- 				<% if(session.getAttribute("user_id") == null) { %> --%>
<%-- 				<li><a href="/MyWeb/user/user_login.jsp">LOGIN</a></li> -->
<%-- 				<li><a href="/MyWeb/user/user_join.jsp" style="color: red">JOIN</a></li> -->
<%-- 				<% } else {%> --%>
<%-- 				<li><a href="/MyWeb/user/user_mypage.jsp">MY PAGE</a></li> -->
<%-- 				<li><a href="/MyWeb/user/user_logout.jsp">LOG OUT</a></li> -->
<%-- 				<% } %> --%>
				
				<c:choose>
					<c:when test="${ sessionScope.user_id == null }">
					<li><a href="/MyWeb/user/login.user">LOGIN</a></li>
					<li><a href="/MyWeb/user/join.user" style="color: red">JOIN</a></li>
					</c:when>
					<c:otherwise>
					<li><a href="/MyWeb/user/mypage.user">MY PAGE</a></li>
					<li><a href="/MyWeb/user/logout.user">LOG OUT</a></li>
					</c:otherwise>
				</c:choose>
				
			</ul>
		</div>


		<!-- /.navbar-collapse -->
	</div>
	<!-- /.container -->
</nav>