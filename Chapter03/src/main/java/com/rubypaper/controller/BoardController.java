package com.rubypaper.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.rubypaper.BoardVO;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * BoardController
 */
// 리턴 페이지 만들지 않기 위해서 restController
@RestController
public class BoardController {

    public BoardController() {
        System.out.println("==> BoardController 생성");
    }

    @GetMapping("/hello")
    public String hello(String name) {
        return "Hello : " + name;
    }

    // 객체
    @GetMapping("/getBoard")
    public BoardVO getBoard() {
        // BoardVO 객체 생성
        BoardVO board = new BoardVO();

        // 객체 정보 설정
        board.setSeq(1);
        board.setTitle("테스트 제목 ...");
        board.setWriter("테스터");
        board.setContent("테스트 내용 입니다......");
        board.setCreateDate(new Date());
        board.setCnt(0);

        // 객체 리턴
        return board;
    }

    // 컬렉션
    @GetMapping("/getBoardList")
    public List<BoardVO> getBoardList() {
        // 컬렉션으로 boradVo 객체 생성
        List<BoardVO> boardList = new ArrayList<BoardVO>();
        // 반복문 사용해서 list에 객체 설정
        for (int i = 1; i <= 10; i++) {
            // BoardVO 객체 생성
            BoardVO board = new BoardVO();

            // 객체 정보 설정
            board.setSeq(i);
            board.setTitle("제목 ..." + i);
            board.setWriter("테스터");
            board.setContent(i + " 번 내용 입니다......");
            board.setCreateDate(new Date());
            board.setCnt(0);
            //객체 list에 넣기
            boardList.add(board);
        }

        return boardList;
    }

}