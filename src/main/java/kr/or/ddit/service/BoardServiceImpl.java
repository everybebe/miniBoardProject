package kr.or.ddit.service;

import java.util.List;

import kr.or.ddit.dao.BoardDaoImpl;
import kr.or.ddit.dao.IBoardDao;
import kr.or.ddit.vo.BoardVO;

public class BoardServiceImpl implements IBoardService {

	private IBoardDao dao;
	
	private static IBoardService service;
	
	public static IBoardService getInstance() {
		if(service==null) service = new BoardServiceImpl();
		return service;
	}
	
	private BoardServiceImpl() {
		dao = BoardDaoImpl.getInstance();
	}
	
	
	@Override
	public int insertBoard(BoardVO vo) {
		return dao.insertBoard(vo);
	}

	@Override
	public int updateBoard(BoardVO vo) {
		return dao.updateBoard(vo);
	}

	@Override
	public int hitBoard(int bo_no) {
		return dao.hitBoard(bo_no);
	}

	@Override
	public int deleteBoard(int bo_no) {
		return dao.deleteBoard(bo_no);
	}

	@Override
	public List<BoardVO> boardList() {
		return dao.boardList();
	}

	@Override
	public BoardVO boardDetail(int bo_no) {
		return dao.boardDetail(bo_no);
	}
	
	

}
