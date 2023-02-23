package org.zerock.controller;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.zerock.mapper.BoardMapperTests;

import lombok.extern.log4j.Log4j;

@Log4j
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"file:src/main/webapp/WEB-INF/spring/root-context.xml","file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
public class BoardControllerTests {
	@Autowired
	WebApplicationContext ctx;
	MockMvc mockmvc;//컨트롤러를 테스트하기 위한 객체
	@Before//하기 전에 해라
	public void setup() {
		mockmvc = MockMvcBuilders.webAppContextSetup(ctx).build();
	}
	@Test
	public void testList() throws Exception {
		log.info(mockmvc.perform(MockMvcRequestBuilders.get("/board/list")).andReturn().getModelAndView().getModelMap());
		log.info(mockmvc.perform(MockMvcRequestBuilders.get("/board/list")).andReturn().getModelAndView().getViewName());//열려야할 페이지 이름
	}
	
	@Test
	public void testRegister() throws Exception {
		log.info(mockmvc.perform(MockMvcRequestBuilders.post("/board/register").param("title", "test title").param("content", "test content")
				.param("writer", "testwriter")).andReturn().getModelAndView().getViewName());
	}
	
	@Test
	public void testGet() throws Exception {
		log.info(mockmvc.perform(MockMvcRequestBuilders.get("/board/get?bno=12")).andReturn().getModelAndView().getModelMap());
		log.info(mockmvc.perform(MockMvcRequestBuilders.get("/board/get").param("bno", "12")).andReturn().getModelAndView().getModelMap());
	}
	@Test
	public void testRemove() throws Exception {
		log.info(mockmvc.perform(MockMvcRequestBuilders.post("/board/remove?bno=18")).andReturn().getModelAndView().getModelMap());
		//log.info(mockmvc.perform(MockMvcRequestBuilders.get("/board/remove").param("bno", "12")).andReturn().getModelAndView().getModelMap());
	}
	
	@Test
	public void testModify() throws Exception {
		log.info(mockmvc.perform(MockMvcRequestBuilders.post("/board/modify").param("title", "Modify test title").param("content", "Modify test content")
				.param("writer", "Modify testwriter").param("bno", "19")).andReturn().getModelAndView().getViewName());
		//log.info(mockmvc.perform(MockMvcRequestBuilders.post("/board/modify").param("bno", "12")).andReturn().getModelAndView().getModelMap());
	}
	
	@Test
	public void testCount() throws Exception {
		//log.info(mockmvc.perform(MockMvcRequestBuilders.get("/board/count")).andReturn().getModelAndView().getModelMap());
		//log.info(mockmvc.perform(MockMvcRequestBuilders.post("/board/modify").param("bno", "12")).andReturn().getModelAndView().getModelMap());
	}
	
	
	
}
