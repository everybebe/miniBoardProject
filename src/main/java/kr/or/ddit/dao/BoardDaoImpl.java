package kr.or.ddit.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.util.MybatisSqlSessionFactory;
import kr.or.ddit.vo.BoardVO;

public class BoardDaoImpl implements IBoardDao{

	private static IBoardDao dao;
	
	public static IBoardDao getInstance() {
		if(dao==null) dao = new BoardDaoImpl();
		return dao;
	}
	
	
	@Override
	public int insertBoard(BoardVO vo) {
		SqlSession session = MybatisSqlSessionFactory.getSqlSession();
		
		int cnt = 0;
		
		try {
			cnt = session.insert("board.insertBoard",vo);
		} finally {
			session.commit();
			session.close();
		}
		return cnt;
	}

	@Override
	public int updateBoard(BoardVO vo) {
		SqlSession session = MybatisSqlSessionFactory.getSqlSession();
		
		int cnt = 0;
		try {
			cnt = session.update("board.updateBoard",vo);
		} finally {
			session.commit();
			session.close();
		}
		return cnt;
	}

	@Override
	public int hitBoard(int bo_no) {
		SqlSession session = MybatisSqlSessionFactory.getSqlSession();
		
		int cnt = 0;
		try {
			cnt = session.update("board.hitBoard",bo_no);
		} finally {
			session.commit();
			session.close();
		}
		return cnt;
	}

	@Override
	public int deleteBoard(int bo_no) {
		SqlSession session = MybatisSqlSessionFactory.getSqlSession();
		
		int cnt = 0;
		try {
			cnt = session.update("board.deleteBoard",bo_no);
		} finally {
			session.commit();
			session.close();
		}
		return cnt;
	}
	@Override
	public List<BoardVO> boardList() {
		SqlSession session = MybatisSqlSessionFactory.getSqlSession();
		
		List<BoardVO> list = null;
		
		try {
			list = session.selectList("board.boardList");
		} finally {
			session.commit();
			session.close();
		}
		return list;
	}


	@Override
	public BoardVO boardDetail(int bo_no) {
		SqlSession session = MybatisSqlSessionFactory.getSqlSession();
		
		BoardVO vo = null;
		
		try {
			vo = session.selectOne("board.boardDetail",bo_no); //디비 결과값 줄 개수가 하나면 one, 여러개면 list
		} finally {
			session.commit();
			session.close();
		}
		return vo;
	}
	

}
