package com.myweb.imgboard.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.myweb.imgboard.model.ImgBoardDAO;
import com.myweb.imgboard.model.ImgBoardVO;

public class ImgContentServiceImpl implements ImgBoardService {

	@Override
	public int execute(HttpServletRequest request, HttpServletResponse response) {
		
		String num = request.getParameter("num");
		ImgBoardDAO dao = ImgBoardDAO.getInstance();
		ImgBoardVO vo = dao.getContent(num);
		
		request.setAttribute("icontent", vo);
		
		if(vo == null) {
			return 0;			
		} else {
			return 1;
		}
		
	}

}
