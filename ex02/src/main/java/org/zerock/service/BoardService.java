package org.zerock.service;

import java.util.List;

import org.zerock.domain.BoardVO;

public interface BoardService {
	//이 메소드는 서비스 측면에서 생각
	
		//1. 게시글 목록 보여주기
		List<BoardVO> getList(); 
		
		//2. 게시글 등록
		void register(BoardVO vo);
		
		//3. 게시글 삭제(정상 동작 여부 확인)
		boolean remove(Long bno);
		
		//3. 게시글 삭제 Alert위해 만든 것
		boolean myremove(Long bno,String delKey);
		
		//4. 게시글 수정(정상 동작 여부 확인)
		boolean modify(BoardVO vo);
		
		//5. 게시글 읽기
		BoardVO get(Long bno);
		
		//보너스 - 전체글 개수를 알려주는 서비스
		Long count();
		
		//오늘의 게시글 수
		Long todayCount();
		
		//오늘의 게시글 리스트 보기
		
		
}
