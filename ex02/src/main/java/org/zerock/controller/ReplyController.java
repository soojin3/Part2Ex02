package org.zerock.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.zerock.domain.ReplyVO;
import org.zerock.service.ReplyService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/replies/")
@AllArgsConstructor
public class ReplyController {
	
	ReplyService service;
	
	//등록(등록할 리플을 json으로 만들어서 보내줌) -> 정상일때만 success 문자를 보내준다
	@PostMapping(value="/new",produces=MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<String> create(@RequestBody ReplyVO vo) {//@RequestBody생략하면 파라메터로 보낼때만
		return service.register(vo)==1 ? //"true": "false";
									new ResponseEntity<>("success",HttpStatus.OK) :
										new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR) ;
										
			
	}
	
	//수정(수정할 리플을 json으로 만들어서 보내줌)
/*	@PutMapping("/{rno}")
	public ResponseEntity<String> modify(@PathVariable("rno") Long rno,@RequestBody ReplyVO vo){
		vo.setRno(rno);
		return service.modify(vo)==1 ? //"true": "false";
				new ResponseEntity<>("success",HttpStatus.OK) :
					new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR) ;
					
	}
	*/
	//수정(수정할 리플을 json으로 만들어서 보내줌)
		@RequestMapping(method= {RequestMethod.PUT,RequestMethod.PATCH},
				value="/{rno}",produces = MediaType.TEXT_PLAIN_VALUE)
		public ResponseEntity<String> modify(@PathVariable("rno") Long rno,@RequestBody ReplyVO vo){
			vo.setRno(rno);
			return service.modify(vo)==1 ? //"true": "false";
					new ResponseEntity<>("success",HttpStatus.OK) :
						new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR) ;
						
		}
	
	//삭제
	@DeleteMapping(value="{rno}",produces = MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<String> remove(@PathVariable("rno") Long rno){
		return service.remove(rno)==1 ? //"true": "false";
				new ResponseEntity<>("success",HttpStatus.OK) :
					new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR) ;
					
	}
	
	//리플 조회
	@GetMapping("{rno}")
	public ReplyVO get(@PathVariable("rno") Long rno){
		return service.get(rno);
	}
	
	//해당글 리플 내역
	@GetMapping("/pages/{bno}")
	public List<ReplyVO> getList(@PathVariable("bno") Long bno){
		return service.getList(bno);
	}
	
	
	
}
