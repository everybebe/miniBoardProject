package kr.or.ddit.dao;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.util.MybatisSqlSessionFactory;
import kr.or.ddit.vo.MemberVO;

public class MemberDaoImpl implements IMemberDao {

	private static IMemberDao dao;
	
	public MemberDaoImpl() {
		
	}
	
	public static IMemberDao getInstance() {
		if(dao==null) dao = new MemberDaoImpl();
		return dao;
	}
	
	@Override
	public int insertMember(MemberVO vo) {

		SqlSession session = MybatisSqlSessionFactory.getSqlSession();
		
		int cnt = 0;
		
		try {
			cnt = session.insert("member.insertMember",vo);
		} finally {
			session.close();
		}
		return cnt;
	}

	@Override
	public MemberVO loginCheck(MemberVO vo) {

		SqlSession session = MybatisSqlSessionFactory.getSqlSession();
		
		
		MemberVO memVo = null;
		
		try {
			memVo = session.selectOne("member.loginCheck",vo);
		} finally {
			session.close();
		}
		
		return memVo;
	}

	

	
}
