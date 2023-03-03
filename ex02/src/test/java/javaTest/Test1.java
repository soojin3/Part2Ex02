package javaTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;
import org.zerock.domain.Criteria;

import lombok.extern.log4j.Log4j;
@Log4j
public class Test1 {
	
	@Test
	public void testList() {
		List<String> list = new ArrayList<>();
		list.add("지금은");
		list.add("5교시");
		list.add("쉬는시간");
		for(String temp :list) {
			log.info(temp);
		}
		list.forEach(aa -> log.info(aa));
		log.info(list);
	}
	
	@Test
	public void testMap() {// ==> 테스트 방법 board/list?type=T&keyword=테
		Map<String, String> map = new HashMap<>();
		map.put("T", "TTT");
		map.put("C", "CC");
		map.put("W", "WWW");
		log.info(map.get("T"));//값 가져오기
		Set<String> key = map.keySet();//전체키 가져오기
		key.forEach(aa -> log.info(aa));
		
		map.values().forEach(aa->log.info(aa));//전체 값 가져오기
		
		log.info(map);
			
	}
	public void testList1() {
		String[] list = new String[] {};//배열 만들기
		for(String temp :list) {//list 가 null 이라면 에러 발생
			log.info(temp);
		}
	}

}
