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

	<form action="<%=request.getContextPath()%>/boardinsert.do" method="post">
		<h2>게시판 등록</h2>
		<label>제목 : </label><input type="text" name="title"><br>
		<label>내용 : </label><input type="text" name="content"><br>
		<input type="submit" class="btn" value="등록" >
		<input type="button" class="btn" value="목록" onclick="location.href='<%=request.getContextPath()%>/boardlist.do'">
	</form>

</body>
</html>