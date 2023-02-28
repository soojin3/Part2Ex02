package org.zerock.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Setter
@Getter
@ToString
public class Criteria {
	//페이지번호
	public int pageNum;
	
	//한번에 보여줄 양 ->한 번에 10개씩 보여준다
	private int amount=10;

	public Criteria() {
		this(1,10);
		
	}
	
	public Criteria(int pageNum,int amount) {
		this.pageNum=pageNum;
		this.amount=amount;
	}
	
}
