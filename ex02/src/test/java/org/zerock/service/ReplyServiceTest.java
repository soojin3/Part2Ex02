package org.zerock.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.log4j.Log4j;

@Log4j
@RunWith(SpringJUnit4ClassRunner.class)//스프링에서 객체를 사용할 수 있게 해 준다.
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class ReplyServiceTest {
	
	@Autowired
	ReplyService service;
	
	//@Transactional
	@Test
	public void testTX() {
		//service.get(230L);
		log.info("테스트가 안되고 있나");
		service.txTest();
//		try {
//			service.txTest();
//			
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
	}
	
	@Test
	public void test() {
		service.get(70L);
	}

}
