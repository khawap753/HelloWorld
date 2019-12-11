package com.myweb.board.service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.myweb.board.model.BoardDAO;
import com.myweb.board.model.BoardVO;

public class ContentServiceImpl implements IBoardService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		String num = request.getParameter("num");
		BoardDAO dao = BoardDAO.getInstance();

		// 게시글 정보 가져오는 메서드
		BoardVO vo = dao.contentBoard(num);

		// 서비스에 진입할 때, 쿠키는 자동으로 전송돼서 들어온다.
		Cookie[] arr = request.getCookies();

		String check = "";

		for (Cookie c : arr) {
			if (c.getName().equals("hitNum" + num)) { // 중복이다
				check = c.getValue();
			}
		}

		if (!check.equals(num)) { // 쿠키에서 꺼낸 check값과 폼에서 넘어온 num값이 같지 않으면 조회수 증가

			// 조회수 올리는 작업
			dao.upHit(num);
		}

		// 화면에 전달하기 위해 화면에 저장함
		request.setAttribute("content_list", vo);

		// 중복증가 방지 쿠키 생성
		Cookie hitCoo = new Cookie("hitNum" + num, num);
		hitCoo.setMaxAge(20);
		response.addCookie(hitCoo);
	}
	
	public void able() {
		
	}

}
