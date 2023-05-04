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
<h1>게시판 상세 보기</h1>
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
			<td><%=vo.getBo_title()%><br> 
			<td><%=vo.getBo_content()%><br> 
			<td><%=vo.getBo_writer()%></td>
			<td><%=vo.getBo_regdate()%></td>
			<td><%=vo.getBo_hit()%></td>
			
		</tr>

	</table>

<input type="button" class="btn" value="수정" onclick="location.href='<%=request.getContextPath()%>/boardupdate.do?bono=<%=vo.getBo_no()%>'">
<input type="button" class="btn" value="삭제" onclick="location.href='<%=request.getContextPath()%>/boarddelete.do?bono=<%=vo.getBo_no()%>'">
<input type="button" class="btn" value="목록" onclick="location.href='<%=request.getContextPath()%>/boardlist.do'">
</body>
</html>