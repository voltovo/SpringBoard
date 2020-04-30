package com.rubypaper.board.security;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

import com.rubypaper.board.domain.Member;

public class SecurityUser extends User{
	
	private static final long serialVersionUID = 1L;
	private Member member;
	
	//비번 암호화 추가로 noop 제거
	public SecurityUser(Member member) {
		super(member.getId(), member.getPassword(), 
				AuthorityUtils.createAuthorityList(member.getRole().toString()));
		this.member = member;
	}
	
	//HTML 화면에서 사용하기 위해 member 리턴
	public Member getMember() {
		return member;
	}
}
