package com.yedam.app.board.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.app.board.mapper.BoardMapper;
import com.yedam.app.board.service.BoardService;
import com.yedam.app.board.service.BoardVO;

@Service	// Bean 등록 -> @Transcational
public class BoardServiceImpl implements BoardService {
	private BoardMapper boardMapper;
	
	@Autowired
	public BoardServiceImpl(BoardMapper boardMapper) {
		this.boardMapper = boardMapper;
	}
	
	@Override	// 현재 게시판의 전체 글 조회
	public List<BoardVO> findBoardList() {
		// TODO Auto-generated method stub
		return boardMapper.selectAllList();
	}
	
	@Override	// 선택한 게시글의 상세 조회
	public BoardVO findBoardInfo(BoardVO boardVO) {
		// TODO Auto-generated method stub
		return boardMapper.selectInfo(boardVO);
	}

	@Override	// 작성한 게시글 등록
	public int createBoard(BoardVO boardVO) {
		// TODO Auto-generated method stub
		int result = boardMapper.insertInfo(boardVO);
		if(result == 1) {
			return boardVO.getBno();
		}
		else {
			return -1;
		}
	}
	
}
