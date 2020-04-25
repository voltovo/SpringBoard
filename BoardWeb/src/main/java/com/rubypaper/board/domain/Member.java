package com.rubypaper.board.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
//순환참조 문제를 해결하기 위해서 boardList 는 제외
@ToString(exclude = "boardList")
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
	
	//일대다(1:N)관계 매핑
	//member 양방향 매핑에서 주인임을 설정 mappedBy
	//member가 조회될 때 Board 목록도 조회되게 Fetch
	@OneToMany(mappedBy = "member", fetch = FetchType.EAGER)
	private List<Board> boardList = new ArrayList<Board>();
}
