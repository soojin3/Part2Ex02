package org.zerock.mapper;

import java.util.List;

import org.zerock.domain.ReplyVO;

public interface ReplyMapper {
	
	//댓글 등록
	public int insert(ReplyVO vo);
	
	//수정
	public int update(ReplyVO reply);
	
	//삭제
	public int delete(Long rno);
	
	//하나의 리플 읽기
	public ReplyVO read(ReplyVO vo);
	
	//하나의 글에 대응하는 리플목록 읽기
	public List<ReplyVO> getlist(Long bno);
	
}
