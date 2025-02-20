package com.yedam.app.board.mapper;

import java.util.List;

import com.yedam.app.board.service.BoardVO;

public interface BoardMapper {
	// 전체조회
	public List<BoardVO> selectAllList();
	
	// 단건조회
	public BoardVO selectOne(BoardVO boardVO);
}
