package com.rubypaper.controller;

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
    
}