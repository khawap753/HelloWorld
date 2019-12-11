package com.myweb.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.myweb.board.service.*;
//	CREATE table t_board (
//	    num number(10) constraint t_board_pk PRIMARY key,
//	    writer VARCHAR2(30),
//	    title VARCHAR2(200),
//	    content VARCHAR2(1000),
//	    regdate date DEFAULT sysdate,
//	    hit NUMBER(5) DEFAULT 0
//	);

//	CREATE SEQUENCE t_board_seq;

@WebServlet("*.board")
public class BoardController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public BoardController() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doAction(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doAction(request, response);
	}

	protected void doAction(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		String command = uri.substring(conPath.length());

		request.setCharacterEncoding("utf-8");
		
		// 인터페이스 선언
		IBoardService sv;
		
		if (command.equals("/board/list.board")) { //
//			response.sendRedirect("board_list.jsp");
			sv = new GetListServiceImpl();
			sv.execute(request, response);
			
			// 화면 이동
			RequestDispatcher dp = request.getRequestDispatcher("board_list.jsp");
			dp.forward(request, response);
			
		} else if (command.equals("/board/write.board")) { // 글쓰기 화면 요청
			response.sendRedirect("board_write.jsp");

		} else if (command.equals("/board/regist.board")) { // 글쓰기 등록 요청
			sv = new RegistServiceImpl(); // 선언한거 가져와서 집어넣는 작업.
			sv.execute(request, response);
			
			// 등록 마친 후 다시 컨트롤러 태워 글 목록을 가지고 이동
			response.sendRedirect("list.board");
			
		} else if(command.equals("/board/content.board")) { // 상세보기 화면 이동
			sv = new ContentServiceImpl();
			sv.execute(request, response);
			
			// 값을 화면에 던져주기 위한 포워드 이동
			RequestDispatcher dp = request.getRequestDispatcher("board_content.jsp");
			dp.forward(request, response);
			
		} else if(command.equals("/board/modify.board")) { // 게시판 수정 화면
			sv = new ModifyServiceImpl();
			sv.execute(request, response);
			
			RequestDispatcher dp = request.getRequestDispatcher("board_modify.jsp");
			dp.forward(request, response);
			
		} else if(command.equals("/board/update.board")) { // 게시판 수정 요청
			sv = new UpdateServiceImpl();
			sv.execute(request, response);
			
			// content.board를 태울 때 반드시 번호에 대한 정보를 넘겨줘야 함.
			String num = request.getParameter("bNum");
			response.sendRedirect("content.board?num=" + num);
			
		} else if(command.equals("/board/delete.board")) {
			sv = new DeleteServiceImpl();
			sv.execute(request, response);
			
			response.sendRedirect("list.board"); 
		}
		
	}
}
