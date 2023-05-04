<%@page import="kr.or.ddit.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    

<%
	MemberVO vo = (MemberVO)request.getAttribute("mem");
	String error = request.getParameter("error");
	if(vo == null) {
%>    
<c:set value="<%=error %>" var="error"/>	

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
<form action="<%=request.getContextPath()%>/login_process.do" method="post" name="loginForm">
	<h1>로그인</h1>
	<label>아이디 : </label><input type="text" name="id" id="id"><br>
	<label>비밀번호 : </label><input type="password" name="pw"><br>
	<input type="button" class="btn" value="로그인" onclick="CheckLogin()">
	<input type="button" class="btn" value="회원가입" onclick="location.href='<%=request.getContextPath()%>/join_process.do'">
</form>
</body>

<%
	}
%>

<script type="text/javascript">
if("${error}" == "1"){
	alert("존재하지 않는 회원입니다.")
}

function CheckLogin() {
	var form = document.loginForm;
	

	//아이디가 입력되었는지 검사한다.
	//아이디가 입력되지 않으면 오류 메세지를 출력하고 해당 입력 항목에 커서가 놓인다.
	if(form.id.value == ""){
		alert("아이디를 입력해주세요!");
		form.id.focus();
		return false;
	}
	
	//비밀번호가 입력되었는지 검사한다.
	//비밀번호가 입력되지 않으면 오류 메세지를 출력하고 해당 입력 항목에 커서가 놓인다.
	if(form.pw.value == "") {
		alert("비밀번호를 입력해주세요.");
		form.pw.focus();
		return false;
		
	}
	
	//폼 페이지에서 입력한 데이터 값을 서버로 전송한다.
	form.submit();
}
</script>

</html>