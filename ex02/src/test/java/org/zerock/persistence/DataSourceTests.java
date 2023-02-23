package org.zerock.persistence;

import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

@Log4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class DataSourceTests {

	@Autowired
	DataSource dataSource;
	// 인터페이스를 구현한 클래스가 스프링에서 인식되고 있다면 자동주입이 가능

	@Autowired
	SqlSessionFactory sqlSessionFactory;

	/*
	 * @Test public void testConnection() { try { dataSource.getConnection();
	 * log.info("커넥션 작업 성공"); } catch (SQLException e) { e.printStackTrace();
	 * log.error("커넥션 작업 실패"); fail(); } /}
	 */
	@Test
	public void testConnection() {
		try {
			dataSource.getConnection();
			log.info("커넥션 작업 성공");
		} catch (SQLException e) {
			e.printStackTrace();
			log.error("커넥션 작업 실패");
			fail();
		}
	}
	
	@Test
	public void testMyBatis() {
//		SqlSession session = null;
//		Connection conn = null;
//		try {
//			System.out.println("마이바티스 성공");
//			log.info("마이바티스 성공");
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			if (conn != null)
//				try {
//					conn.close();
//				} catch (SQLException e) {
//				}
//			;
//			if (session != null) {
//				session.close();
//			}
//
//		}

		
		// try with resource 로 변경

		try (SqlSession session2 = sqlSessionFactory.openSession(); Connection conn2 = session2.getConnection();) {
			log.info("마이바티스 성공");
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}

	}

	@Test
	public void testsTryWithResource() {
		// 콘솔에서 사용자로 숫자하나 입력받는다.
		// 숫자를 출력한다.
		/*
		 * 1. 예외처리 없이 구현 2. 예외처리 포함 구현 (try catch 구문으로 구현) 3. try with recource 구문으로 구현
		 * 
		 */
		try (Scanner in = new Scanner(System.in);) {
			log.info("숫자하나 입력해라");
			log.info(in.nextInt());
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
