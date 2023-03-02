package org.zerock.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.domain.LastVO;
import org.zerock.domain.RankVO;

public interface BoardMapper {//인터페이스는 언제나 public 이다. 
	
	//게시물 목록 가져오기
	//@Select("select*from TBL_BOARD")
	List<BoardVO> getList();
	
	//NEW
	//게시물 목록 가져오기
	List<BoardVO> getListWithiPaging(Criteria cri);
	
	//게시글 등록 return int 등록된 글의 개수
	//void insert (BoardVO vo);//vo객체 넣어주기
	int insert (BoardVO vo);//vo객체 넣어주기
	
	//게시글 등록시 등록된 글번호 알기
	int insertSelectKey(BoardVO vo);
	
	//게시글 수정  (수정된 글의 개수)
	int update(BoardVO vo);
	//게시글 삭제
	int delete(Long bno);
	//게시글 읽기
	BoardVO read(Long bno);
	
	//bonus 등록할 글번호 확인하기
	long myselectKey();
	
	//bonus 확인된 글 번호로 글 등록하기
	int myInsert(BoardVO vo);
	
	//전체 글 개수 확인 
	Long count(Criteria cri);//원래 괄호가 비었는데 추가한 이유는 검색한 조건으로 페이지 조건 나오도록
	
	//오늘의 게시글 수
	Long todayCount();
	
	//순위 / 글쓴이 / 글 개수 board/rank
	List<RankVO> rank();

	//가장 최근에 작성된 글 --> 글번호 가장 큰 것 뽑기 , 나오는건 글 제목만 나오게 하기
	List<LastVO> last();
	
	//방문횟수 세기
	Long visit();

	//Long visitUp(Long bno);

	

}
