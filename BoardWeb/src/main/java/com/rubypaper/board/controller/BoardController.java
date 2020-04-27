package com.rubypaper.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rubypaper.board.domain.Board;
import com.rubypaper.board.service.BoardService;

@Controller
@RequestMapping("/board/")
public class BoardController {
	
	//BoardService 의존성 주입
	@Autowired
	private BoardService boardService;
	
	@RequestMapping("/getBoardList")
	public String getBoardList(Model model, Board board) {
		Page<Board> boardList = boardService.getBoardList(board);
		model.addAttribute("boardList", boardList);
		
		return "board/getBoardList";
	}
}
