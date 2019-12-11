package com.myweb.board.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface IBoardService {

	// Service클래스가 사용할 추상 메서드 선언.
	public void execute(HttpServletRequest request, HttpServletResponse response);

}
