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

@WebServlet("/boardupdate.do")
public class boardupdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 내용을 불러와야 함
		
		request.setCharacterEncoding("UTF-8");
		
		String no = request.getParameter("bono");
		
		int boardNo = Integer.parseInt(no);

		IBoardService service = BoardServiceImpl.getInstance();
		
		BoardVO vo = service.boardDetail(boardNo);
		
		request.setAttribute("boardDetail",vo);
		request.getRequestDispatcher("/WEB-INF/views/boardUpdate.jsp").forward(request, response);
		
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//수정 처리
		 request.setCharacterEncoding("UTF-8");
			
	     String no = request.getParameter("bono");
	     String title = request.getParameter("title");
	     String content = request.getParameter("content");
	     System.out.println(no);
	     
		 int boardNo = Integer.parseInt(no);
		 
		 BoardVO vo = new BoardVO(); 
		 vo.setBo_no(boardNo);
		 vo.setBo_title(title);
		 vo.setBo_content(content);
		 
		 
		 
		 System.out.println("no : " + vo.getBo_no()); 
		 System.out.println("title : " + vo.getBo_title()); 
		 System.out.println("content : " + vo.getBo_content());
		 
		 IBoardService service = BoardServiceImpl.getInstance();
		 
		 service.updateBoard(vo);
		 
		 //response.sendRedirect(request.getContextPath()+"/boardlist.do");
		 response.sendRedirect(request.getContextPath() + "/boardlist.do");
	
	}


}
