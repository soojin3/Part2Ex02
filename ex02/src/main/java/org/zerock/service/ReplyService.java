package org.zerock.service;

import java.util.List;

import org.zerock.domain.ReplyVO;

public interface ReplyService {
	//등록 
	int register(ReplyVO vo);
	
	//수정
	int modify(ReplyVO vo);
	
	//삭제
	int remove(Long rno);
	
	//리플한개 가져오기
	ReplyVO get(Long rno);
	
	//글에 해당하는 리플목록 가져오기
	List<ReplyVO> getList(Long bno);
	
	//트랜잭션 테스트용
	void txTest();
	
}
