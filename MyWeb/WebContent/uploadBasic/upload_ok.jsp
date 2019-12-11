<%@page import="java.util.Enumeration"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	
	String fileName = "";
	String name = "";
	String title = "";
	String fileType = "";

	String uploadFilePath = request.getServletContext().getRealPath("uploadBasic");
	
	int filesize = 5 * 1024 * 1024;
	
	String encoding = "UTF-8";
	
	try {
		
	MultipartRequest multi = new MultipartRequest(
				request,
				uploadFilePath,
				filesize,
				encoding,
				new DefaultFileRenamePolicy()
			);
			
			fileName = multi.getFilesystemName("fileName");
			
			name = multi.getParameter("name");
			title = multi.getParameter("title");
			
			Enumeration en = multi.getFileNames();
			String getName = (String)en.nextElement();
			fileType = multi.getContentType(getName);
			
			
			
	} catch(Exception e) {
		e.printStackTrace();
	}
	
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>파일 업로드에 성공했습니다.</h2>
	실제 파일 경로 :<%=uploadFilePath %><br>
	글쓴이 :<%=name %><br>
	제목 :<%=title %><br>
	파일명 :<%=fileName %><br>
	파일타입 :<%=fileType %><br>
	<a href="upload.jsp">업로드 하기</a>
	
</body>
</html>