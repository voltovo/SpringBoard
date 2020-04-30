package com.rubypaper.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rubypaper.board.domain.Board;
import com.rubypaper.board.security.SecurityUser;
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
	
	@RequestMapping("/getBoard")
	public String getBoard(Board board, Model model) {
		model.addAttribute("board", boardService.getBoard(board));
		return "board/getBoard";
	}
	
	
	@GetMapping("/insertBoard") 
	public String insertBoardView() { return
	  "board/insertBoard"; 
	}
	 
	@PostMapping("/insertBoard")
	public String insertBoard(Board board, @AuthenticationPrincipal SecurityUser principal) {
		board.setMember(principal.getMember());
		boardService.insertBoard(board);
		return "redirect:getBoardList";
	}
	
	//글등록 시 Member 엔티티를 Board 엔티티에 설정하기 위해서 수정
	/*
	 * @PostMapping("/insertBoard") public String insertBoard(Board board) {
	 * boardService.insertBoard(board); return "redirect:getBoardList"; }
	 */
	
	@GetMapping("/deleteBoard")
	public String deleteBoard(Board board) {
		boardService.deleteBoard(board);
		return "forward:getBoardList";
	}
	
	@PostMapping("/updateBoard")
	public String updateBoard(Board board) {
		boardService.updateBoard(board);
		return "forward:getBoardList";
	}
	}
