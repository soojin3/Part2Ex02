package org.zerock.mapper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.BoardVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class BoardMapperTests {
	@Setter(onMethod_ = @Autowired)//세터주입
	BoardMapper mapper;
	
	@Test
	public void testGetList(){
		//List<BoardVO> list = mapper.getList();
		//for(BoardVO vo : mapper.getList()) {
		//	log.info(vo);
		//}
		//위와 아래는 동일한 의미
		mapper.getList().forEach(vo -> log.info(vo));
	}
	
	@Test
	public void insertTest() {
		BoardVO vo = new BoardVO();
		vo.setTitle("01스프링으로 작성");
		vo.setContent("01스프링으로 작성함");
		vo.setWriter("01수진-스프링");
		//mapper.insert(vo);
		log.info("삽입된 행 개수: "+mapper.insert(vo));
	}
	
	@Test
	public void insertSelectKey() {
		BoardVO vo = new BoardVO();
		vo.setTitle("01스프링으로 작성");
		vo.setContent("01스프링으로 작성함");
		vo.setWriter("01수진-스프링");
		log.info("삽입된 행 개수: "+mapper.insertSelectKey(vo));
		log.info(vo);
	}
	
	@Test
	public void myInsert() {
		BoardVO vo = new BoardVO();
		vo.setTitle("The max2Day23작성");
		vo.setContent("Max_Day23");
		vo.setWriter("23newbie");
		vo.setBno(mapper.myselectKey());
		mapper.myInsert(vo);
		log.info(vo);
	}
	
	@Test
	public void update() {
		BoardVO vo = new BoardVO();
		vo.setTitle("수정한다");
		vo.setContent("수정한다");
		vo.setWriter("수정한다");
		vo.setBno(43L);
		mapper.update(vo);
		log.info(vo);
	}
	
	@Test
	public void delete() {
		mapper.delete(9L);
	}
	
	@Test
	public void testDelete() {
		log.info("삭제된 개수"+mapper.delete(8L));
	}
	
	@Test
	public void read() {
		mapper.read(10L);
	}
	
	@Test
	public void testcount() {//전체 글 개수 확인 (메소드 이름:count)
		mapper.count();
	}
	
	@Test
	public void testtodayCount() {//오늘 글 개수 확인 (메소드 이름:todayCount)
		mapper.todayCount();
	}
	
	@Test//오늘의 게시글 목록 가져오기
	public void testTodaydateList() {
		mapper.getList().forEach(vo -> log.info(vo));
	}
	@Test
	public void testSamename() {
		
	}

}
