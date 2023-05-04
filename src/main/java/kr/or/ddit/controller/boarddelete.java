package kr.or.ddit.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.service.BoardServiceImpl;
import kr.or.ddit.service.IBoardService;
import kr.or.ddit.vo.BoardVO;

@WebServlet("/boarddelete.do")
public class boarddelete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		int boardNo = Integer.parseInt(request.getParameter("bono"));
		
		IBoardService service = BoardServiceImpl.getInstance();
		
		service.deleteBoard(boardNo);
		

		response.sendRedirect(request.getContextPath() + "/boardlist.do");
		
	}

}
