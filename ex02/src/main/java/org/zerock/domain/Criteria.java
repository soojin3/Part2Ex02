package org.zerock.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class Criteria {
	// 페이지번호
	public int pageNum;

	// 한번에 보여줄 양 ->한 번에 10개씩 보여준다
	private int amount = 10;

	// 검색 조건
	private String type;// 예) 제목T, 작성자W, 내용C, 제목 or 작성자TW ...3개 모두는 TWC

	// 검색어
	private String keyword;

	public Criteria() {
		this(1, 10);

	}

	public Criteria(int pageNum, int amount) {
		this.pageNum = pageNum;
		this.amount = amount;
	}

	public String[] getTypeArr() {
		if(type!=null) {
			//String[] strArr = type.split("");// (",")컴마 기준으로 자른다. 아무것도 안쓰면 한글자씩 분해("")
			return type.split("");
			
		}else {
			return new String[] {};//비어있지만 null은 아니게 리턴할때 사용
			//why? 배열객체가 null이면 foreach 돌릴때 에러발생함으로
		}
		//return (type!=null) ? type.split("") : new String[] {}; 위와 같은 뜻
		
	}

}
