package com.myweb.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.myweb.user.service.IUserService;
import com.myweb.user.service.UserDeleteFormImpl;
import com.myweb.user.service.UserJoinServiceImpl;
import com.myweb.user.service.UserLoginServiceImpl;
import com.myweb.user.service.UserUpdateFormImpl;
import com.myweb.user.service.UserUpdateServiceImpl;

@WebServlet("*.user")
public class UserController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
 
    public UserController() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);
	}
	
	protected void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		String command = uri.substring(conPath.length());
		request.setCharacterEncoding("utf-8");
		IUserService sv;
		
		
		if(command.equals("/user/join.user")) {
			response.sendRedirect("user_join.jsp");
		} else if(command.equals("/user/joinForm.user")) {
			sv = new UserJoinServiceImpl();
			int result = sv.execute(request, response);
			
			if(result == 1) {
//				response.setContentType("text/html"); // 응답 객체의 형식
//				response.setCharacterEncoding("utf-8"); // 응답 객체의 인코딩 타입
//				PrintWriter out = response.getWriter();
//				out.println("<script>");
//				out.println("alert('이미 존재하는 회원입니다.')");
//				out.println("location.href='user_join.jsp'");
//				out.println("</script>");
				request.setAttribute("msg", "이미 존재하는 회원 입니다.");
				RequestDispatcher dp = request.getRequestDispatcher("user_join.jsp");
				dp.forward(request, response);
				
			} else {
				response.sendRedirect("user_login.jsp");
			}
			
		// 로그인 화면 요청	
		} else if(command.equals("/user/login.user")) {
			response.sendRedirect("user_login.jsp");
		} else if(command.equals("/user/loginForm.user")) {
			
			// 1. UserLoginServiceImpl() 생성
			
			sv = new UserLoginServiceImpl();
			int result = sv.execute(request, response);
			
			if(result == 1) { // 로그인 성공
				response.sendRedirect("user_mypage.jsp");
				
			} else { // 로그인 실패 
				request.setAttribute("msg", "아이디 혹은 비밀번호가 일치하지 않습니다.");
				RequestDispatcher dp = request.getRequestDispatcher("user_login.jsp");
				dp.forward(request, response);
			}
		
		// 마이페이지 화면 요청
		} else if(command.equals("/user/mypage.user")) {
			response.sendRedirect("user_mypage.jsp");
			
		// 로그아웃 화면 요청	
		} else if(command.equals("/user/logout.user")) {
			HttpSession session = request.getSession();
			session.removeAttribute("user_id"); // 세션 삭제
			response.sendRedirect("/MyWeb");
		
		// 회원정보 수정 화면 요청
		} else if(command.equals("/user/update.user")) {
			
			// 1. 업데이트 화면 진입할 때, 회원 정보 화면에 출력.
			// 2. UserUpdateServiceImpl() 을 생성하고 execute() 메서드 실행
			sv = new UserUpdateServiceImpl();
			int result = sv.execute(request, response);
			
			if(result == 1) { // 성공
				RequestDispatcher dp = request.getRequestDispatcher("user_update.jsp");
				dp.forward(request, response);
				
			} else { // 실패
				response.sendRedirect("user_mypage.jsp");
			}
		
		// 회원정보 변경 처리
		} else if(command.equals("/user/updateForm.user")) {
			
			// 1. UserUpdateFormImpl()을 생성, execute문 메서드 실행
			// 2. 서비스에서는 화면에서 값을 받아서 업데이트 진행
			// 3. 업뎃 성공시 스크립트 "업뎃 정상 처리 되었습니다" 출력 update_mypage.jsp 이동
			// 4. 실패시 user_update.jsp 이동
			sv =  new UserUpdateFormImpl();
			int result  = sv.execute(request, response);
			
			if( result == 1) {
				response.setContentType("text/html");
				response.setCharacterEncoding("utf-8");
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('업데이트가 정상적으로 완료되었습니다.')");
				out.println("location.href='user_mypage.jsp'");
				out.println("</script>");
				
			} else {
				response.sendRedirect("update.user");
			}
			
		} else if(command.equals("/user/delete.user")) {
			response.sendRedirect("user_delete.jsp");
			
		// 탈퇴 처리	
		} else if(command.equals("/user/deleteForm.user")) {
			sv = new UserDeleteFormImpl();
			int result = sv.execute(request, response);
			
			if(result == 1) { // 탈퇴 성공
				HttpSession session = request.getSession();
				session.removeAttribute("user_id");
				response.sendRedirect("/MyWeb");
			} else { // 탈퇴 실패
				request.setAttribute("msg", "기존 비밀번호를 확인하세요.");
				RequestDispatcher dp = request.getRequestDispatcher("user_delete.jsp");
				dp.forward(request, response);
			}
		
			
		}
	
	}

}
