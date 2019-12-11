package com.myweb.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// .test로 끝나는 모든 요청을 다 받아들이겠다.
@WebServlet("*.test") 
public class TestController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
  
    public TestController() {
        super();
     
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);
	}
	
	protected void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 상세 요청을 분기하기 위해 URI정보를 사용함
		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		String command = uri.substring(conPath.length());
		System.out.println(command);
		
		if(command.equals("/join.test")) {
			// join 기능 실행
		} else if(command.equals("/delete.test")) {
			// delete 기능 실행
		} else if(command.equals("/")) {
			// ... 기능 실행 ...
		}
	}

}
