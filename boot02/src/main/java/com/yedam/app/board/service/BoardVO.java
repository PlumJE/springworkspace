package com.yedam.app.board.service;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class BoardVO {
	private Integer bno;	// 게시글 번호
	private String title;	// 게시글 제목
	private String contents;// 게시글 내용
	private String writer;	// 게시글 작성자
	// java.util.Date : yyyy/MM/dd
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date regdate;	// 최초 작성일
	private Date updatedate;// 최근 수정일
	private String image;	// 첨부이미지
}
