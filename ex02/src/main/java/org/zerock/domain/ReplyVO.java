package org.zerock.domain;

import java.util.Date;

import lombok.Data;
@Data
public class ReplyVO {//이름 틀리면 매핑 안된다
	private Long rno;
	private Long bno;
	private String reply;
	private String replyer;
	private Date replydate;//date는 자바 Util
	private Date updatedate;

}
