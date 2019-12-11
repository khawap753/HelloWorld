package com.myweb.board.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.myweb.board.model.BoardDAO;
import com.myweb.board.model.BoardVO;
import com.myweb.util.PageVO;

public class GetListServiceImpl implements IBoardService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		BoardDAO dao = BoardDAO.getInstance();
//		ArrayList<BoardVO> list = dao.getList();
		
		// 페이징된 리스트를 가져오는 작업
		int pageNum = 1;
		
		if(request.getParameter("pageNum") != null) {
			String num = request.getParameter("pageNum");
			pageNum = Integer.parseInt(num);
		}
		
		ArrayList<BoardVO> list = dao.getList(pageNum);
		
		// 토탈 구함
		int total = dao.getTotal();
		
		// 페이지네이션 세팅
		PageVO page = new PageVO(pageNum, total, 10);
		
		// 화면에 전달하기 위해서 request에 강제 저장
		request.setAttribute("board_list", list);
		
		// 페이징 계사 결과를 화면에 보내기 위한 작업
		request.setAttribute("pageVO", page);
		
	}

}
