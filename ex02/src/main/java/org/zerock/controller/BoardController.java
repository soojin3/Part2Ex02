package org.zerock.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
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
	public String register(BoardVO vo, RedirectAttributes rttr) {
		log.info("url register...");
		service.register(vo);
		log.info("입력된 글 번호"+vo.getBno());
		rttr.addFlashAttribute("bno",vo.getBno());
		
		//목록으로 돌아가기
		return "redirect:/board/list";
	}
	
	@GetMapping("/get")
	public void get(Long bno, Model model) {
		log.info("url get...");
		model.addAttribute("board",service.get(bno));
	}
	
	@PostMapping("/remove")
	public String remove(Long bno,RedirectAttributes rttr) {
		log.info("url remove...");
		service.remove(bno);
		rttr.addFlashAttribute("removebno",bno);
		return "redirect:/board/list";
	}
	
	@GetMapping("/modify")//수정화면 출력
	public void modify(Long bno,Model model) {
		model.addAttribute("board",service.get(bno));
	}
	
	@PostMapping("/modify")//addFlashAttribute로 해야 한다.
	public String modify(BoardVO vo,RedirectAttributes rttr) {
		log.info("url modify....."+vo);
		service.modify(vo);
		rttr.addFlashAttribute("modifybno",vo.getBno());
		return "redirect:/board/list";
	}
	
	@GetMapping("/count")
	public void count(Model model,Long bno) {
		log.info("count...");
		model.addAttribute("bno",service.count());
	}

}
