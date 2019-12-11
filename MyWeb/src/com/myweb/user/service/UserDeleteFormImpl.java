package com.myweb.user.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.myweb.user.model.MemberDAO;

public class UserDeleteFormImpl implements IUserService {

	@Override
	public int execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("user_id");
		String pw = request.getParameter("pw");
		MemberDAO dao = MemberDAO.getInstance();
		int result = dao.userCheck(id, pw);
		
		if(result == 1) {
			dao.deleteUser(id);
			return 1;
		} else {			
			return 0;
		}	
	}
}
