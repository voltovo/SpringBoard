package com.rubypaper.board.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
public class Member {
	
	@Id
	@Column(name = "MEMBER_ID")
	private String id;
	
	private String password;
	private String name;
	
	//권한 정보를 문자열로 저장하기 위해서 EnumType 설정
	@Enumerated(EnumType.STRING)
	private Role role;
	
	private boolean enabled;
}
