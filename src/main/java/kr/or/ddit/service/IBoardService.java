package kr.or.ddit.service;

import java.util.List;

import kr.or.ddit.vo.BoardVO;

public interface IBoardService {
	//글 작성
	public int insertBoard(BoardVO vo);
	
	//글 수정
	public int updateBoard(BoardVO vo);
	
	//조회수
	public int hitBoard(int bo_no);
	
	//삭제
	public int deleteBoard(int bo_no);
	
	//목록
	public List<BoardVO> boardList();
	
	//상세보기	
	public BoardVO boardDetail(int bo_no);
}
