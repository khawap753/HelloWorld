package com.myweb.user.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.myweb.user.model.MemberDAO;
import com.myweb.user.model.MemberVO;

public class UserJoinServiceImpl implements IUserService {

	@Override
	public int execute(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		MemberDAO dao = MemberDAO.getInstance();
		int result = dao.confirmId(id);
		
		if(result == 1) {
			return 1; // 아이디 중복
		} else {
			MemberVO vo = new MemberVO(id, pw, name, email, address);
			dao.insert(vo); // PK이기 때문에 더이상 확인해볼 필요는 없다.
			return 0;
		}
		
	}

}
