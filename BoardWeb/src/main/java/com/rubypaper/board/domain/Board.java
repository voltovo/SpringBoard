package com.rubypaper.board.domain;

import java.util.Date;

import javax.persistence.Column;
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
//순환참조 문제를 해결하기 위해서 member 제외
@ToString(exclude = "member")
@Entity
public class Board {
	
	@Id
	//자동으로 증가되는 값을 할당
	@GeneratedValue
	private Long seq;
	
	private String title;
	private String content;

	//jpa가 수정작업할 때 해당 컬럼 포함 X
	@Temporal(TemporalType.TIMESTAMP)
	@Column(updatable = false)
	private Date createDate = new Date();
	
	//jpa가 수정작업할 때 해당 컬럼 포함 X
	@Column(updatable = false)
	private Long cnt = 0L;
	
	//다대일(N:1)관계 매핑
	//양방향 매핑에서 N쪽에 해당
	//MEMBER_ID 칼럼을 통해서 외래키를 관리하도록 JoinColum 설정
	//내부조인으로 처리하기 위해서 nullable = false
	@ManyToOne
	@JoinColumn(name = "MEMBER_ID", nullable=false, updatable = false)
	private Member member;
	
	public void setMember(Member member) {
		this.member = member;
		member.getBoardList().add(this);
	}
}
