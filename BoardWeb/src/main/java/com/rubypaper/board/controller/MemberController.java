package com.rubypaper.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rubypaper.board.domain.Member;
import com.rubypaper.board.service.MemberService;

@Controller
@RequestMapping("/member/")
public class MemberController {
	
	//MemberService 의존성 주입
	@Autowired
	private MemberService memberService;
	
	@RequestMapping("/join")
	public String memberJoinView() {
		return "member/join";
	}
	
	//회원가입
	@PostMapping("/memberJoin")
	public String memberJoin(Member member) {
			memberService.insertMember(member);
		return "redirect:index";
	}
	
}
