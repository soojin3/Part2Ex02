package org.zerock.domain;

import lombok.Data;

@Data
public class PageDTO {
	// 페이지바정보 10개씩 보여준다고 정했을때

	// 시작번호, 끝번호
	private int startPage, endPage;

	// 이전, 다음 표시유무
	private boolean prev, next;

	// 전체 글 개수(끝번호 알기 위해)
	private long total;

	// 현재페이지와 보여줄 글 개수
	private Criteria cri;

	public PageDTO(long total, Criteria cri) {
		this.total = total;// 전체글 개수가this.total, 그냥totalal이 pageDTO의 total
		this.cri = cri;

		// 10뒤에 0.0붙어서 bouble 형으로 만들기
		endPage = (int) (Math.ceil(cri.getPageNum() / 10.0)) * 10;
		startPage = endPage - 9;
		//진짜 마지막 페이지
		int realEnd=(int)(Math.ceil(total*1.0/cri.getAmount()));
		
		if(realEnd<endPage) {//계산된 마지막 페이지가 실제 마지막 페이지보다 크면 변하게
			endPage=realEnd;
		}
		/*
		 * if(startPage==1) { 
		 * prev=false; 
		 * }else {
		 *  prev=true; }
		 */
		//위와 같음 간단히 작성
		prev=(startPage!=1);//1이 아니라면 트루
		//prev=(startPage>1);//위와 동일
		
		next=(endPage!=realEnd);//다음 페이지
		//next=(endPage<realEnd);//위와 동일
		
		
		
	}
}
