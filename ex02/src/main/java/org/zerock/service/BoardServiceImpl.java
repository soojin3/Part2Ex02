package org.zerock.service;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.zerock.domain.BoardVO;
import org.zerock.mapper.BoardMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
@Service//component
@Log4j
@AllArgsConstructor//생성자 주입
public class BoardServiceImpl implements BoardService {
	
	
	BoardMapper mapper;
	
	
	@Override
	public List<BoardVO> getList() {
		log.info("getList 요청 ...");
		return mapper.getList();
	}

	@Override
	public void register(BoardVO vo) {
		log.info("register..."+vo);//+vo를 해서 맞나 확인
		mapper.insertSelectKey(vo);//입력한 글의 번호가 vo의 bno에 들어온다.
		//mapper.insert(vo);	<-이게 전에 쓰더던 것 
		// TODO Auto-generated method stub

	}

	@Override
	public boolean remove(Long bno) {
		log.info("remove..."+bno);
		//if(mapper.delete(bno)==1) {
		//	return true;
		//}else {
		//	return false;
		//}
		//삼항연산자를 사용한다면 
		//return (mapper.delete(bno)==1 ? true : false;
		
		//더 짧은 것, 가장 간결
		return mapper.delete(bno)==1;
		
	}

	@Override
	public boolean modify(BoardVO vo) {
		log.info("modify..."+vo);
		return mapper.update(vo)==1;
	}

	@Override
	public BoardVO get(Long bno) {
		log.info("get..."+bno);
		return mapper.read(bno);
	}

	@Override
	public Long count() {
		log.info("count");
		return mapper.count();
	}
	
	@Override
	public Long todayCount() {
		log.info("todayCount");
		return mapper.todayCount();
	}
	
	//@Override
	//public Long todayList() {
	//	log.info("todayCount");
	//	return mapper.todayCount();
	//}

}
