package org.zerock.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.BoardVO;
import org.zerock.domain.ChartWriterRank;
import org.zerock.domain.Criteria;
import org.zerock.domain.LastVO;
import org.zerock.domain.PageDTO;
import org.zerock.domain.RankVO;
import org.zerock.service.BoardService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@Controller
@RequestMapping("/board/*")
@AllArgsConstructor
public class BoardController {
	BoardService service;

	@GetMapping("")
	public void all() {

	}

	@GetMapping("/list")
	public void list(Model model, Criteria cri) {
		log.info("list...");
		model.addAttribute("list", service.getList(cri));
		// 페이지 정보 전달
		//객체 만들기: PageDTO pageDTO = new PageDTO(123, cri);
		//PageDTO dto=new PageDTO(123, cri);//전송 확인
		//log.info("페이지 정보 "+dto);//전송 확인
		//model.addAttribute(new PageDTO(500, cri));//리턴타입의 classDTO를 봐라, 이름을 적어 보내지 않아도 이름이 같다
		
		//페이지 속도개선 편법 튜닝
		//1. 최초에 테이블 개수 한번 읽기
		//2. 이후에는 어차피 테이블 개수는 늘어날테니 그 값 이상일때만 
		
		model.addAttribute(new PageDTO(service.count(cri),cri));//리턴타입의 classDTO를 봐라, 이름을 적어 보내지 않아도 이름이 같다
		
		
	}

	@GetMapping("/register")
	public void register() {

	}

	@PostMapping("/register")
	public String register(BoardVO vo, RedirectAttributes rttr) {
		log.info("url register...");
		service.register(vo);
		log.info("입력된 글 번호" + vo.getBno());
		rttr.addFlashAttribute("bno", vo.getBno());

		// 목록으로 돌아가기
		return "redirect:/board/list";
	}

	@GetMapping("/get")
	public void get(Long bno, Model model, Criteria cri,Long visit) {
		log.info("url get...");
		model.addAttribute("board", service.get(bno));
		service.visit(bno,visit);//bno번호가 더해짐 수정 완료
		//model.addAllAttributes("",service.get(visit));
		model.addAttribute("cri", cri);//페이지 정보를 유지하기 위해 보냄
	}

	@PostMapping("/remove")
	public String remove(Long bno, RedirectAttributes rttr, String delKey, Criteria cri) {
		log.info("url remove...");
		// service.remove(bno);
		if (service.myremove(bno, delKey)) {//삭제처리
			rttr.addFlashAttribute("removebno", bno);
		} else {
			rttr.addFlashAttribute("removebno", "-1");
		}
		return "redirect:/board/list?pageNum="+cri.getPageNum()+"&amount="+cri.getAmount();
	}

	@GetMapping("/modify") // 수정화면 출력
	public void modify(Long bno, Model model,Criteria cri) {
		model.addAttribute("board", service.get(bno));
		model.addAttribute("cri", cri);
	}

	@PostMapping("/modify") // addFlashAttribute로 해야 한다.
	public String modify(BoardVO vo, RedirectAttributes rttr,Criteria cri) {
		log.info("url modify....." + vo);
		service.modify(vo);
		rttr.addFlashAttribute("modifybno", vo.getBno());
		return "redirect:/board/list?pageNum="+cri.getPageNum()+"&amount="+cri.getAmount();
	}

	@GetMapping("/count")
	public void count(Model model, Long bno, Criteria cri) {
		log.info("count...");
		model.addAttribute("bno", service.count(cri));
	}

	@GetMapping("/rank")
	public void rank(Model model) {
		log.info("rank...");
		List<RankVO> list = service.rank();
		model.addAttribute("list", list);

	}

	@GetMapping("/last")
	public void last(Model model) {
		log.info("last...");
		List<LastVO> list = service.last();
		model.addAttribute("list", list);
		// model.addAttribute("rankList",service.rankList());

	}
	@GetMapping("/chart")
	public void chart(Model model) {
		//views/board/chart.jsp
		ChartWriterRank chartwriterank = service.chartWriterRank();
		String mylabels="[";
		for(String labels : chartwriterank.getMylabels()) {
			mylabels += "\""+labels + "\",";
		}
		mylabels = mylabels.substring(0, mylabels.length()-1)+"]";//마지막에..
		log.info("잘 만들었나"+mylabels);
		//jsp데이터 보내기
		//배열을 만들어서 보내기
		model.addAttribute("mylabels",mylabels);
		model.addAttribute("mydata",Arrays.toString(chartwriterank.getMydata()));
	}
	
	@GetMapping("/chart2")//기본화면만 보내고 ajax로 처리하기
	public void chart2() {
		
	}

}
