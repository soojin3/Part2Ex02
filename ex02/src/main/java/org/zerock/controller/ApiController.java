package org.zerock.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.service.BoardService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
public class ApiController {

	BoardService bs;

	@GetMapping(value = "/api/board/bno/{num}")
	public BoardVO getBoard(@PathVariable("num") long num) {
		return bs.get(num);

	}

	@GetMapping(value = "/api/board/{type}/{keyword}/{amount}")
	public List<BoardVO> getSearchList(@PathVariable("type") String type, @PathVariable("keyword") String keyword,
			@PathVariable("amount") int amount) {
		Criteria cri = new Criteria(1, amount);// 한 페이지에 amount개수만큼 넣겠다는 뜻이다.
		cri.setType(type);
		cri.setKeyword(keyword);

		return bs.getList(cri);
	}

	@GetMapping(value = "/api/board/count", produces = "test/plain;charset=UTF-8")
	public String getCount() {
		return bs.count(new Criteria()) + "";

	}

	@GetMapping(value = "/api/board/count") //파라메터는 ?로 받는다, param적어줄 필요 없다. 1234가 아닌 경우, 맞으면 글 개수 보여주기
	public ResponseEntity<String> getCount2(int key) {
		if (key == 1234) {
			return ResponseEntity.status(HttpStatus.OK).body(bs.count(new Criteria()) + "");
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("0");
		}

	}
	
	@GetMapping(value = "/api/board/count/new/{bno1}/{bno2}/{bno3}")//글번호로 3개 입력해서 글 3개 가져오기,배열을 만들어서 전달
	public List<BoardVO> getNew(@PathVariable("bno1") long bno1,@PathVariable("bno2") long bno2,@PathVariable("bno3") long bno3) {
		List<BoardVO> list = new ArrayList<BoardVO>();
		list.add(bs.get(bno1));
		list.add(bs.get(bno2));
		list.add(bs.get(bno3));
		//리턴이 리스트면 이렇게 쓰는거 가능하다. new ArrayList<BoardVO>().add(bs.get(bno1)).add(bs.get(bno2)).add(bs.get(bno3));
		return list;
	}
	
	@GetMapping(value = "/api/board/count/new/**")// *두개는 하위폴더도 가능함
	public List<BoardVO> getNew2(HttpServletRequest request) {
		String url = request.getRequestURI();
		String bnoStr = url.substring(15);//5/6/7/8/9
		List<BoardVO> list = new ArrayList<BoardVO>();
		String[] bnoArr = bnoStr.split("/");
		for(String bno : bnoArr) {
			list.add(bs.get(Long.parseLong(bno)));
			//System.out.println(bno);
		}
		return list;
	}

}
