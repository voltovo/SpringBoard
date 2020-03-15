package com.rubypaper.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.rubypaper.BoardVO;

/**
 * BoardServiceImpl
 */
public class BoardServiceImpl implements BoardService {

    @Override
    public String hello(String name) {
        return "Hello : " + name;
    }

    @Override
    public BoardVO getBoard() {
        BoardVO board = new BoardVO();
        board.setSeq(1);
        board.setTitle("테스트 제목  ...");
        board.setWriter("테스터");
        board.setContent("테스트 내용입니다......");
        board.setCreateDate(new Date());
        board.setCnt(0);

        return board;
    }

    @Override
    public List<BoardVO> getBoardList() {
        List<BoardVO> boardList = new ArrayList<BoardVO>();
        for (int i = 0; i < 10; i++) {
            BoardVO board = new BoardVO();
            board.setSeq(i);
            board.setTitle("제목  ..." + i);
            board.setWriter("테스터");
            board.setContent(i + " 번의 테스트 내용입니다......");
            board.setCreateDate(new Date());
            board.setCnt(0);
            boardList.add(board);
        }
        return boardList;
    }

}