package org.zerock.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zerock.domain.ReplyVO;
import org.zerock.mapper.ReplyMapper;

import lombok.AllArgsConstructor;
@Service//꼭 넣어야 한다. 그래야 루트에서 인식된다
@AllArgsConstructor
public class ReplyServiceImpl implements ReplyService {
	ReplyMapper mapper;
	
	@Override
	public int register(ReplyVO vo) {
		return mapper.insert(vo);
	}

	@Override
	public int modify(ReplyVO vo) {
		return mapper.update(vo);
	}

	@Override
	public int remove(Long rno) {
		return mapper.delete(rno);
	}

	@Override
	public ReplyVO get(Long rno) {
		return mapper.read(rno);
	}

	@Override
	public List<ReplyVO> getList(Long bno) {
		return mapper.getList(bno);
	}

	@Transactional
	@Override
	public void txTest() {
		//두개의 매퍼를 실행 (하나만 수행이 되면 안됨-트랜잭션 처리)
		//리플에 두개
		//기존에 있는 rno에 값을 추가 -->무조건 충돌
		//새로운 리플이 
		mapper.tx2();//이것이 에러 안나는 것
		mapper.tx1();
		
		
	}

}
