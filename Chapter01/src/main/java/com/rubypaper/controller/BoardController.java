package com.rubypaper.controller;

import java.util.Date;

import com.rubypaper.domain.BoardVO;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * BoardController
 */
//리턴 페이지 만들지 않기 위해서 restController
@RestController
public class BoardController {

    public BoardController(){
        System.out.println("==> BoardController 생성");
    }

    @GetMapping("/hello")
    public String hello(String name){
        return "Hello : " + name;
    }

    //객체 저장
    @GetMapping("/getBoard")
    public BoardVO getBoard(){
        //BoardVO 객체 생성
        BoardVO board = new BoardVO();

        //객체 정보 설정
        board.setSeq(1);
        board.setTitle("테스트 제목 ...");
        board.setWriter("테스터");
        board.setContent("테스트 내용 입니다......");
        board.setCreateDate(new Date());
        board.setCnt(0);

        //객체 리턴
        return board;
    }
    
}