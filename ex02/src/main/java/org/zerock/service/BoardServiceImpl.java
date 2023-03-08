package org.zerock.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.zerock.domain.BoardVO;
import org.zerock.domain.ChartWriterRank;
import org.zerock.domain.Criteria;
import org.zerock.domain.LastVO;
import org.zerock.domain.RankVO;
import org.zerock.domain.WriterRank;
import org.zerock.mapper.BoardMapper;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
@Service//component
@Log4j
//@AllArgsConstructor//생성자 주입
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	BoardMapper mapper;
	
	@Value("${delKey}")
	String delKey;
	
	
	@Override
	public List<BoardVO> getList(Criteria cri) {
		log.info("getList 요청 ...");
		return mapper.getListWithiPaging(cri);
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
		//mapper.visitUp(bno);
		return mapper.read(bno);
	}

	@Override
	public Long count(Criteria cri) {
		log.info("count");
		return mapper.count(cri);
	}
	
	@Override
	public Long todayCount() {
		log.info("todayCount");
		return mapper.todayCount();
	}

	@Override
	public boolean myremove(Long bno, String delKey) {
		log.error("에러아님 확인된 값 "+this.delKey);
		if(delKey.equals(this.delKey)) {
			return mapper.delete(bno)==1;
		}else {
			return false;
		}
	}
	
	//@Override
	//public Long todayList() {
	//	log.info("todayCount");
	//	return mapper.todayCount();
	//}
	
	

	@Override
	public List<RankVO> rank() {
		return mapper.rank();
	}
	
	@Override
	public List<LastVO> last() {
		return mapper.last();
	}

	//@Override
	//public boolean visit(Long bno) {
	//	log.info("visiter ..."+mapper.visit(bno));
//		return mapper.visit(bno)==1;
	//}

	@Override
	public void visit(Long bno,Long visit) {
		log.info("visiter...");
		mapper.visit(bno);
		//return mapper.visit(bno);
	}

	@Override
	public ChartWriterRank chartWriterRank() {
		List<WriterRank> list= mapper.writerRank(); 
		//원하는 데이터 형식으로 변형 시키기 
		//1. 리턴할 객체를 생성
		ChartWriterRank chartWriterRank = new ChartWriterRank();
		//2. 리턴할 객체에 값 세팅
		//3. 문자열 배열과 숫자 배열 생성
		String[] mylabels = new String[5];
		int[] mydata = new int[5];
		//4. 각각의 배열에 값 매핑 후 리턴할 객체에 넣어줌
		int i=0;
		for(WriterRank rank:list) {
			mylabels[i]=rank.getWriter();
			mydata[i]=rank.getCn();
			i++;
		}
		log.info("작성자들 "+mylabels);
		log.info("갯수들 "+mydata);
		chartWriterRank.setMylabels(mylabels);
		chartWriterRank.setMydata(mydata);
		return chartWriterRank;
	}


}
