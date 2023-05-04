package kr.or.ddit.dao;

import kr.or.ddit.vo.MemberVO;

public interface IMemberDao {

	public int insertMember(MemberVO vo);
	
	public MemberVO loginCheck(MemberVO vo);
}
