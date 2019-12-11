package com.myweb.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.myweb.imgboard.service.ImgBoardService;
import com.myweb.imgboard.service.ImgUpdateServicrImpl;

@WebServlet("*.IBoard")
public class IBoardController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public IBoardController() {
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

		ImgBoardService imgboard;

		if (command.equals("/imgboard/imgUpdate.imgboard")) {
			imgboard = new ImgUpdateServicrImpl();
			imgboard.execute(request, response);
			response.sendRedirect("imgUpdate.jsp");

		} else if (command.equals("/imgboard/imgUpdate.imgboard")) {
			imgboard = new ImgUpdateServicrImpl();
			imgboard.execute(request, response);
			response.sendRedirect("imgUpdate.jsp");

		} else if (command.equals("/imgboard/imgUpdate.imgboard")) {
			imgboard = new ImgUpdateServicrImpl();
			imgboard.execute(request, response);
			response.sendRedirect("imgUpdate.jsp");

		} else if (command.equals("/imgboard/imgUpdate.imgboard")) {
			imgboard = new ImgUpdateServicrImpl();
			imgboard.execute(request, response);
			response.sendRedirect("imgUpdate.jsp");

		}

	}

}
