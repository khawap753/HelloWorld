package com.myweb.board.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.myweb.board.model.BoardDAO;

public class UpdateServiceImpl implements IBoardService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		String num = request.getParameter("bNum");
		String writer = request.getParameter("bWriter");
		String title = request.getParameter("bTitle");
		String content = request.getParameter("bContent");
		
		BoardDAO dao = BoardDAO.getInstance();
		dao.updateBoard(num, writer, title, content);
	}

}
