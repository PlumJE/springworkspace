package com.yedam.app.board.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.yedam.app.board.service.BoardService;
import com.yedam.app.board.service.BoardVO;

@Controller	// Routing
public class BoardController {
	private BoardService boardService;
	
	@Autowired
	public BoardController(BoardService boardService) {
		this.boardService = boardService;
	}
	
	// 전체조회 기능
	// 1) URL + Method
	// 2) Service
	// 3) View
	@GetMapping("boardList")
	public String boardList(Model model) {
		List<BoardVO> list = boardService.findBoardList();
		model.addAttribute("boards", list);
		return "board/list";
		// classpath:/templates/board/list.html을 말한다.
		// ViewResolver : 경로 생성
		// prefix : classpath:/templates
		// suffix : .html
	}

	// 단건조회 기능
	// 1) URL + Method
	// 2) Service
	// 3) View
	@GetMapping("boardInfo")	// 커맨드 객체(디폴트), @RequestParam
	public String boardInfo(BoardVO boardVO, Model model) {
		BoardVO findVO = boardService.findBoardInfo(boardVO);
		model.addAttribute("board", findVO);
		return "board/info";
		// classpath:/templates/board/info.html을 말한다.
		// ViewResolver : 경로 생성
		// prefix : classpath:/templates
		// suffix : .html
	}
}
