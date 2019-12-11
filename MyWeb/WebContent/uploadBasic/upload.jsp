<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="upload_ok.jsp" method="post" enctype="multipart/form-data">
		글쓴이 :<input type="text" name="name"><br>
		제목 :<input type="text" name="name"><br>
		파일 :<input type="file" name="fileName"><br>
		<input type="submit" value="등록"><br>
	</form>
</body>
</html>