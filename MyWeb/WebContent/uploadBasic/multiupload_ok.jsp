<%@page import="java.util.Enumeration"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	ArrayList<String> list = new ArrayList<>();
	
	String uploadFilePath = request.getServletContext().getRealPath("uploadBasic");
	
	int filesize = 5 * 1024 * 1024;
	
	String encoding = "UTF-8";
	
	try {
		MultipartRequest multi = new MultipartRequest(request, uploadFilePath, filesize, encoding, new DefaultFileRenamePolicy());
		Enumeration files = multi.getFileNames();
		while(files.hasMoreElements()) {
			String file = (String)files.nextElement();
			String fileName = multi.getFilesystemName(file);
			String fileContent = multi.getContentType(file);
			
			out.println(file);
			out.println(fileName);
			out.println(fileContent);
			
			
		}
		
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

</body>
</html>