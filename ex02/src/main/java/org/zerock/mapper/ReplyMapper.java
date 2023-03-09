package org.zerock.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.zerock.domain.ReplyVO;

public interface ReplyMapper {
	
	//댓글 등록
	public int insert(ReplyVO vo);
	
	//수정
	public int update(ReplyVO reply);
	
	//삭제
	public int delete(Long rno);
	
	//하나의 리플 읽기
	public ReplyVO read(Long rno);
	
	//하나의 글에 대응하는 리플목록 읽기
	public List<ReplyVO> getList(Long bno);
	
	//두개 이상의 파라미터가 들어갈 경우 mybatis에서 처리하는 법
	//두개의 글을 읽는 쿼리
	public List<ReplyVO> testMybatis(@Param("reply")ReplyVO reply, @Param("rno2")Long rno2);
	
	//트랜잭션 처리테스트용
	public void tx1();
	public void tx2();
	
}
