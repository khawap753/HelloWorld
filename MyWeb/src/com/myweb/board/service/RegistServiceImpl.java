package com.myweb.board.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.myweb.board.model.BoardDAO;

public class RegistServiceImpl implements IBoardService {

	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		String writer = request.getParameter("bName");
		String title = request.getParameter("bTitle");
		String content = request.getParameter("bContent");
		
		BoardDAO dao = BoardDAO.getInstance();
		dao.regist(writer, title, content);
		
	}

}
