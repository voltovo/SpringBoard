package com.rubypaper.board.service;

import org.springframework.data.domain.Page;

import com.rubypaper.board.domain.Board;
import com.rubypaper.board.domain.Search;

public interface BoardService {
	
	void insertBoard(Board board);
	
	void updateBoard(Board board);
	
	void deleteBoard(Board board);
	
	Board getBoard(Board board);
	
	//검색기능 추가로 수정 (Board --> Search)
	Page<Board> getBoardList(Search search);
}
