package com.rubypaper.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
//상호 호출로 인한 오류 때문에 재설정
@ToString(exclude = "boardList")
@Entity
public class Member {
	@Id
	@Column(name = "MEMBER_ID")
	private String id;
	private String password;
	private String name;
	private String role;
	
	//fetch = 연관관계에 있는 게시판 정보도 같이 조회할 것인지 결정
	//mappedBy = 연관관계의 주인을 지정 (현재 게시판 구조상 Board테이블의 member 컬럼이 연관관계의 주인)
	@OneToMany(mappedBy = "member", fetch = FetchType.EAGER)
	private List<Board> boardList = new ArrayList<Board>();
}
