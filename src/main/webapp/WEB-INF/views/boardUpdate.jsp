<%@page import="kr.or.ddit.vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
	BoardVO vo = (BoardVO) request.getAttribute("boardDetail");

%>


<form action="<%=request.getContextPath()%>/boardupdate.do?bono=<%=vo.getBo_no() %>" method="post">
<h1>게시판 수정</h1>
<table border='1'>

	<tr>
		<th>번호</th>
		<th>제목</th>
		<th>내용</th>
		<th>작성자</th>
		<th>작성일</th>
		<th>조회수</th>
	</tr>


		<tr>
			<td><%=vo.getBo_no() %></td>
			<td><input type="text" name="title" value=<%=vo.getBo_title()%>><br> 
			<td><input type="text" name="content" value=<%=vo.getBo_content()%>><br> 
			<td><%=vo.getBo_writer()%></td>
			<td><%=vo.getBo_regdate()%></td>
			<td><%=vo.getBo_hit()%></td>
			
		</tr>

	</table>
	<input type="submit" class="btn" value="수정">
	
</form>
</body>
</html>