<%@page import="kr.or.ddit.vo.MemberVO"%>
<%@page import="javax.websocket.Session"%>
<%@page import="java.util.List"%>
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

List<BoardVO> boardlist = (List<BoardVO>)request.getAttribute("boardlist");
//MemberVO mvo = (MemberVO)session.getAttribute("mem");
%>
<h1>게시판 목록</h1>
<table border='1'>

	<tr>
		<th>번호</th>
		<th>제목</th>
		<th>작성자</th>
		<th>작성일</th>
		<th>조회수</th>
	</tr>
	
<%
	if(boardlist.size() == 0) {
		
%>	
	<tr><td colspan="5">조회하실 게시글이 존재하지 않습니다.</td></tr>	
<% } else {
	for(BoardVO vo : boardlist) {

%>
		<tr>
			<td><%=vo.getBo_no() %></td>
			<td><a href="<%=request.getContextPath()%>/boardDetail.do?bono=<%=vo.getBo_no() %>"><%=vo.getBo_title()%></a><br> 
			<td><%=vo.getBo_writer()%></td>
			<td><%=vo.getBo_regdate()%></td>
			<td><%=vo.getBo_hit()%></td>
			
		</tr>
<% 	 
 }
}
%> 

	</table>

<input type="submit" value="글쓰기" onclick="location.href='<%=request.getContextPath()%>/boardinsert.do'">

	</form>
</body>
</html>