
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-idth, initial-scale=1">
   

    <title>Welcome to MyWorld</title>

	<!-- 외부에 정의된 css파일을 import시키는 방법 -->

    <!-- Bootstrap Core CSS -->
    <link href="/MyWeb/css/bootstrap.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="/MyWeb/css/business-casual.css" rel="stylesheet">

    <!-- Fonts -->
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Josefin+Slab:100,300,400,600,700,100italic,300italic,400italic,600italic,700italic" rel="stylesheet" type="text/css">
	
	 <!-- jQuery -->
    <script src="/MyWeb/js/jquery.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="/MyWeb/js/bootstrap.min.js"></script>
<style>
	.div_center {
		margin-bottom: 20px;
		margin-top:20px;
		padding: 30px 15px;

	}
</style>



</head>
<body>
	<jsp:include page="../include/header.jsp"/>

	<div align="center" class="div_center">
	<form action="updateForm.user" method="post" id="updateForm">
		<h3>회원정보 수정 페이지</h3>
		<hr>
		<table border="1">
			<tr>
				<td>아이디</td>
				<td>
					<input type="text" name="id" value="${ user_vo.id }" readonly="readonly">
				</td>
			</tr>
			<tr>
				<td>비밀번호</td>
					<td>
						<input type="password" name="pw" placeholder="비밀번호는 5자 이상 입력" id="pw">
					</td>
				</tr>
				<tr>
					<td>비밀번호 확인</td>
					<td>
						<input type="password" name="pw_check" placeholder="비밀번호는 5자 이상 입력" id="pw_check">
					</td>
			</tr>
			<tr>
				<td>이름</td>
				<td>
					<input type="text" name="name" value="${ user_vo.name }" id="name">
				</td>
				
			</tr>

			<tr>
				<td>이메일</td>
				<td>
					<input type="text" name="email" value="${ user_vo.email }" placeholder="ex) abc@def.com">
				</td>
			</tr>
			<tr>
				<td>주소</td>
				<td>
					<input type="text" name="address" value="${ user_vo.address }" placeholder="ex) OO시 OO구">
				</td>
			</tr>
		</table>
		<br>
		
		<input type="button" value="수정" class="btn btn-default" onclick="updateForm()">&nbsp;&nbsp;
		<input type="button" value="취소" class="btn btn-default" onclick="location.href='mypage.user'">    
		
	</form>	
	</div>

	<script>
		function updateForm() {
			// 비밀번호, 확인이 다르면 비밀번호와 확인이 다르다는 경고창 출력
			// 비밀번호 크기가 5보다 작으면 비번은 5자 이상 입력 경고창 출력
			// 이름이 공백이면 이름은 필수 기입 사항 입니다 경고 출력
			var a = document.getElementById("pw").value; // 두번째 방법
			var b = document.getElementById("pw_check").value;
			var c = document.getElementById("pw").value.length;
			var d = document.getElementById("name").value.length;
			
			if(a != b) {
				alert("비밀번호 확인란을 확인하세요.");
				return;
			} else if(c < 5) {
				alert("비밀번호 크기는 5자 이상이어야 합니다.");
				return;
			} else if(d < 1) {
				alert("이름은 필수 기입 항목 입니다.");
				return;
			} else {
				alert("정보를 수정하시겠습니까?");
				document.getElementById("updateForm").submit();
			}
			
		}
	</script>

	<jsp:include page="../include/footer.jsp"/>
	
</body>
</html>