<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
label{
	display: inline-block;
    width: 80px;
    text-align: right;
    padding: 5px;
}
.btn {
	width:100px;
	background: white;
	border:1px solid black;
}

</style>
<body>
<form action="join_process.do" method="post" name="joinForm">
<h1>회원가입</h1>
<label>아이디 : </label><input type="text" name="id"><br>
<label>비밀번호 : </label><input type="password" name="pw"><br>
<label>이름 : </label><input type="text" name="name"><br>
<input type="button" class="btn" value="등록" onclick="CheckJoin()">
<input type="button" class="btn" value="뒤로" onclick="location.href='<%=request.getContextPath()%>/login_process.do'">
</form>
</body>


<script type="text/javascript">
if("${error}" == "1") {
	alert("서버 에러! 다시 시도 해주세요! ")
}

 function CheckJoin() {
	 var form = document.joinForm;
	 
		if(form.id.value == "" || form.pw.value == "" ||form.name.value == ""){
			alert("가입에 필요한 정보가 부족합니다.");
			form.id.select;
			return false;
		} else {
			alert("회원가입 성공!");
			
		}
		
		form.submit();
		
		
 }

</script>
</html>