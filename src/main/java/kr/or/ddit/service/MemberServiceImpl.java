package kr.or.ddit.service;

import java.util.List;

import kr.or.ddit.dao.BoardDaoImpl;
import kr.or.ddit.dao.IBoardDao;
import kr.or.ddit.dao.IMemberDao;
import kr.or.ddit.dao.MemberDaoImpl;
import kr.or.ddit.vo.BoardVO;
import kr.or.ddit.vo.MemberVO;

public class MemberServiceImpl implements IMemberService {

	private IMemberDao dao;
	
	private static MemberServiceImpl service;
	
	public MemberServiceImpl() {
		dao = MemberDaoImpl.getInstance();
	}

	public static MemberServiceImpl getInstance() {
		if(service == null) service = new MemberServiceImpl();
		return service;
	}
	@Override
	public int insertMember(MemberVO vo) {
	
		return dao.insertMember(vo);
	}

	@Override
	public MemberVO loginCheck(MemberVO vo) {
	
		return dao.loginCheck(vo);
	}
	
	
}
