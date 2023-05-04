package kr.or.ddit.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import kr.or.ddit.service.IMemberService;
import kr.or.ddit.service.MemberServiceImpl;

import kr.or.ddit.dao.IMemberDao;

import kr.or.ddit.vo.MemberVO;


@WebServlet("/login_process.do")
public class login_process extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);

	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		String id = request.getParameter("id");
		String pw = request.getParameter("pw");

		MemberVO vo = new MemberVO();

		vo.setMem_id(id);
		vo.setMem_pw(pw);

		IMemberService service = MemberServiceImpl.getInstance();

		// DB에서 id와 password가 일치하는 데이터 검색해서 가져오기
		MemberVO loginCheck = service.loginCheck(vo);

		HttpSession session = request.getSession();


		if(loginCheck != null) {
			session.setAttribute("mem", loginCheck);
			response.sendRedirect("boardlist.do");
		} else {
			response.sendRedirect("login_process.do?error=1");
		}

	}


}
