package org.zerock.domain;

import java.util.Arrays;

import lombok.Data;

@Data
public class ChartWriterRank {//서비스에 리턴해 줄 형태
	private String[] mylabels;//배열 만들어 주기
	private int[] mydata;
	

}
