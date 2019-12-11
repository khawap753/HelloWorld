package com.myweb.user.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.myweb.user.model.MemberDAO;
import com.myweb.user.model.MemberVO;

public class UserUpdateServiceImpl implements IUserService {

	@Override
	public int execute(HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session = request.getSession();
		String uid = (String)session.getAttribute("user_id");
		MemberDAO dao = MemberDAO.getInstance();
		MemberVO vo = dao.getMemberInfo(uid);

		if (vo == null) {
			return 0;
		} else {
			request.setAttribute("user_vo", vo); // 화면에 넘겨줄 vo 저장
			return 1;
		}
	}
}
