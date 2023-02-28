package org.zerock.domain;

public class PageDTO {
	//페이지바정보 
	
	//시작번호, 끝번호
	private int startPge, endPage;
	
	//이전, 다음 표시유무
	private boolean prev,next;
	
	//전체 글 개수(끝번호 알기 위해)
	private int total;
	
	//현재페이지와 보여줄 글 개수
	private Criteria cri;
	
	public PageDTO(int total,Criteria cri) {
		this.total=total;//전체글 개수가this.total, 그냥totalal이 pageDTO의 total
		this.cri=cri;
	}
}
