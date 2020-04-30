package com.rubypaper.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
//상호 호출로 인한 오류 때문에 재설정
@ToString(exclude = "member")
@Entity
public class Board {
	@Id @GeneratedValue
	private Long seq;
	private String title;
	//private String writer;
	private String content;
	@Temporal(value = TemporalType.TIMESTAMP)
	private Date createDate;
	private Long cnt;
	//Member 객체와 연관 매핑 처리
	//N:1(다대일) 관계 설정
	@ManyToOne
	//외래키 매핑 , 내부조인 추가 (nullable)
	@JoinColumn(name = "MEMBER_ID", nullable = false)
	private Member member;
	
	public void setMember(Member member) {
		this.member = member;
		member.getBoardList().add(this);
	}
}
