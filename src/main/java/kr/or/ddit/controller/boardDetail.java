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

@WebServlet("/boardDetail.do")
public class boardDetail extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String no = request.getParameter("bono");
		
		
		int boardNo = Integer.parseInt(no);

		IBoardService service = BoardServiceImpl.getInstance();
		
		BoardVO vo = service.boardDetail(boardNo);
		
		service.hitBoard(boardNo);
		
		request.setAttribute("boardDetail",vo);
		
		request.getRequestDispatcher("/WEB-INF/views/boardDetail.jsp").forward(request, response);
		
	}

	

}
