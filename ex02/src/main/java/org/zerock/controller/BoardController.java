package org.zerock.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zerock.domain.BoardVO;
import org.zerock.service.BoardService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
@Log4j
@Controller
@RequestMapping("/board/*")
@AllArgsConstructor
public class BoardController {
	BoardService service;
	
	@GetMapping("/list")
	public void list(Model model) {
		log.info("list...");
		model.addAttribute("list",service.getList());
	}
	@GetMapping("/register")
	public void register() {
		
	}
	
	@PostMapping("/register")
	public String register(BoardVO vo) {
		log.info("url register...");
		service.register(vo);
		log.info("입력된 글 번호"+vo.getBno());
		//목록으로 돌아가기
		return "redirect: /board/list";
	}
	
	@GetMapping("/get")
	public void get(Long bno,Model model) {
		log.info("url get...");
		model.addAttribute("board"+service.get(bno));
	}
	@PostMapping("/remove")
	public void remove(Long bno) {
		log.info("url remove...");
		service.remove(bno);
	}
	
	@PostMapping("/modify")
	public void modify(BoardVO vo) {
		log.info("modify...");
		service.modify(vo);
	}
	
	@GetMapping("/count")
	public void count(Model model,Long bno) {
		log.info("count...");
		model.addAttribute("bno",service.count());
	}

}
