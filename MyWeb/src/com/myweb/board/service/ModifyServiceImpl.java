package com.myweb.board.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.myweb.board.model.BoardDAO;
import com.myweb.board.model.BoardVO;

public class ModifyServiceImpl implements IBoardService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		// 화면에서 넘어온 값을 조회해서 담아 넘어감.
		// DAO의 contentBoard() 메서드 활용
		// request 저장
		// 컨트롤러에서 board_modify.jsp로 이동, 화면에 출력, 번호는 수정할 수 없도록 막음.
		String num = request.getParameter("num");
		BoardDAO dao = BoardDAO.getInstance();
		BoardVO vo = dao.contentBoard(num);
		
		request.setAttribute("content_list", vo);
	}

}
