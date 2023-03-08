package org.zerock.mapper;

import java.util.List;
import java.util.stream.IntStream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.ReplyVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class ReplyMapperTests {
	@Setter(onMethod_ = @Autowired)//세터주입
	ReplyMapper mapper;
	
	@Test
	public void testGetList(){
		//List<BoardVO> list = mapper.getList();
		//for(BoardVO vo : mapper.getList()) {
		//	log.info(vo);
		//}
		//위와 아래는 동일한 의미
		//mapper.getList().forEach(vo -> log.info(vo));
	}
	
	@Test
	public void insertTest() {
		ReplyVO vo = new ReplyVO();
		vo.setBno(4L);
		vo.setReply("댓글 작성중");
		vo.setReplyer("댓글 작성자");
//		mapper.insert(vo);
		
		log.info("삽입된 행 개수: "+mapper.insert(vo));
	}
	
	@Test
	public void testInsert2() {
		//5개의 게시글에 2개씩 리플을 달고 싶다
		Long[] bnoArr = {229L,228L,227L, 226L, 225L};
		for(int i=0;i<=9;i++) {//10번 반복
			ReplyVO vo = new ReplyVO();
			vo.setBno(bnoArr[i%5]);//글 번호 선택
			vo.setReply("리플 번호는 "+i+1);
			vo.setReplyer("리플러 "+i+1);
			mapper.insert(vo);
		}
		
		IntStream.range(1, 10).forEach(i -> {
			ReplyVO vo = new ReplyVO();
			vo.setBno(bnoArr[i%5]);//글 번호 선택
			vo.setReply("람다식 리플 번호는 "+i+1);
			vo.setReplyer("람다식 리플러 "+i+1);
			mapper.insert(vo);
			
		} );
		
	}
	
	@Test
	public void update() {//오류
		ReplyVO vo = new ReplyVO();
//		vo.setBno(2L);
//		vo.setReply("리플이다");
//		vo.setReplyer("리플러");
//		mapper.insert(vo); //등록테스트
		
//		vo.setRno(38L);
//		vo.setReply("수정1");
//		vo.setReplyer("수정2");
//		mapper.update(vo); //수정테스트
		
//		log.info("55번 댓글"+mapper.read(10L)); //읽기 테스트
//		
//		
		mapper.getList(228L).forEach(temp->log.info("댓글 목록"+temp));//댓글목록테스트
	}
	
	
	@Test
	public void delete() {//성공
		mapper.delete(37L);
	}

	@Test
	public void read() {//성공
		mapper.read(3L);
	}
	
	@Test
	public void mybatis() {//
		ReplyVO vo = new ReplyVO();
		vo.setRno(5L);
		mapper.testMybatis(vo, 10L);
	}



}
