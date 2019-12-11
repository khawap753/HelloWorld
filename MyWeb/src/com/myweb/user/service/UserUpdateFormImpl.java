package com.myweb.user.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.myweb.user.model.MemberDAO;
import com.myweb.user.model.MemberVO;

public class UserUpdateFormImpl implements IUserService {

	@Override
	public int execute(HttpServletRequest request, HttpServletResponse response) {
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String address = request.getParameter("address");

		System.out.println(id);
		
		MemberDAO dao = MemberDAO.getInstance();
		MemberVO vo = new MemberVO(id, pw, name, email, address);

		int result = dao.updateUser(vo);

		System.out.println(result);
		return result;

	}
}
