package com.myweb.user.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.myweb.user.model.MemberDAO;

public class UserLoginServiceImpl implements IUserService {

	@Override
	public int execute(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		MemberDAO dao = MemberDAO.getInstance();
		
		int result = dao.userCheck(id, pw);
		
		if(result == 1) {
			HttpSession session = request.getSession();
			session.setAttribute("user_id", id);
			return 1;
		} else {
			
			return 0;
		}

	}

}
