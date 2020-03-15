package com.rubypaper.service;

import java.util.List;

import com.rubypaper.BoardVO;

/**
 * BoardService
 */
public interface BoardService {

    String hello(String name);

    BoardVO getBoard();

    List<BoardVO> getBoardList();
}