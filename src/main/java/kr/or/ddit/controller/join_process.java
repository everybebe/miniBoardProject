package kr.or.ddit.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.dao.MemberDaoImpl;
import kr.or.ddit.service.IMemberService;
import kr.or.ddit.service.MemberServiceImpl;
import kr.or.ddit.vo.MemberVO;

/**
 * Servlet implementation class join_process
 */
@WebServlet("/join_process.do")
public class join_process extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		request.getRequestDispatcher("/WEB-INF/views/join.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		
		MemberVO vo = new MemberVO();
		vo.setMem_id(id);
		vo.setMem_pw(pw);
		vo.setMem_name(name);
		
		IMemberService service = MemberServiceImpl.getInstance();
		
		int result = service.insertMember(vo);
		
		if(result == 1) {
		request.setAttribute("join", result);
		response.sendRedirect("login_process.do");
		} else {
			response.sendRedirect("join_process.do?error=1");
		}
		
		
		}
}
