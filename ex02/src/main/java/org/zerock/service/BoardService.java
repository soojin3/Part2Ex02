package org.zerock.service;

import java.util.List;

import org.zerock.domain.BoardVO;
import org.zerock.domain.ChartWriterRank;
import org.zerock.domain.Criteria;
import org.zerock.domain.LastVO;
import org.zerock.domain.RankVO;

public interface BoardService {
	//이 메소드는 서비스 측면에서 생각
	
		//1. 게시글 목록 보여주기
		List<BoardVO> getList(Criteria cri); 
		
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
		
		//전체글 개수를 알려주는 서비스
		Long count(Criteria cri);
		
		//오늘의 게시글 수
		Long todayCount();

		//오늘의 게시글 리스트 보기
		
		//게시글 순위 보기
		List<RankVO> rank();

		//최근 글 보기
		List<LastVO> last();
		
		//조회수(동작 여부 확인)
		//boolean visit(Long bno);
		
		//글 번호 더해줌; 고치기
		//Long visit(BoardVO boardVO);
		void visit(Long bno);
		
		//차트용 랭킹 서비스
		ChartWriterRank chartWriterRank();//5등으로 정해져 있기 때문에 파라메터 넣어줄 필요 없ㅎ음
}
