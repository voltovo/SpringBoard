package com.rubypaper.board.service;

import org.springframework.stereotype.Service;

import com.rubypaper.board.domain.Member;

@Service
public class MemberServiceImpl implements MemberService{

	@Override
	public void insertMember(Member member) {
		System.out.println(member.toString());	
	}

}
