package com.myweb.imgboard.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.myweb.imgboard.model.ImgBoardDAO;
import com.myweb.imgboard.model.ImgBoardVO;

public class ImgUpdateServicrImpl implements ImgBoardService {

	@Override
	public int execute(HttpServletRequest request, HttpServletResponse response) {
		ImgBoardDAO dao = ImgBoardDAO.getInstance();
			
		return 0;
	}

}
