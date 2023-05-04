package kr.or.ddit.service;

import kr.or.ddit.vo.MemberVO;

public interface IMemberService {
	
	public int insertMember(MemberVO vo);
	
	public MemberVO loginCheck(MemberVO vo);
}
