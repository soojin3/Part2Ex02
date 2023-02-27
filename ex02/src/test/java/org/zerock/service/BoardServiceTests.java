package org.zerock.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.BoardVO;
import org.zerock.mapper.BoardMapperTests;

import lombok.extern.log4j.Log4j;

@Log4j
@RunWith(SpringJUnit4ClassRunner.class)//스프링에서 객체를 사용할 수 있게 해 준다.
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class BoardServiceTests {//테스트에서는 생성자주입 !!절대 !!불가 예) new BoardService()
	@Autowired//스프링에서 사용 가능
	BoardService service;//인터페이스 주입 사용 가능
	
	@Test
	public void testGerList() {
		service.getList().forEach(vo -> log.info(vo));//남다식
		
	}
	
	@Test
	public void testRegister() {
		BoardVO vo = new BoardVO();
		vo.setTitle("서비스 제목");
		vo.setContent("서비스 내용");
		vo.setWriter("서비스 작성자");
		service.register(vo);
	}
	
	@Test
	public void testRemove() {
		log.info("성공여부"+service.remove(14L));
	}
	
	@Test
	public void testModify() {
		BoardVO vo = new BoardVO();
		vo.setTitle("내가 수정");
		vo.setContent("Modified person");
		vo.setWriter("I'm that writer");
		vo.setBno(13L);
		log.info("성공여부 :"+service.modify(vo));
	}
	
	@Test
	public void testGet() {
		service.get(10L);
	}
	
	@Test
	public void testCount() {
		service.count();
	}
	
	@Test
	public void testTodayCount() {
		service.todayCount();
	}
	
	@Test
	public void testRank() {
		service.rank();
	}
	
	@Test
	public void testLast() {
		service.last();
	}

}
