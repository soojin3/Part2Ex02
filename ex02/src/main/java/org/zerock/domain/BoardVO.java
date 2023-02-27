package org.zerock.domain;

import java.util.Date;

import lombok.Data;
@Data
public class BoardVO {
	private Long bno;//null받기 위해 객체로 선언
	private String title;
	private String content;
	private String writer;
	private Date regdate;
	private Date updatedate;
	private Long count;
	

}
