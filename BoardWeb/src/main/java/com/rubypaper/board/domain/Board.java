package com.rubypaper.board.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
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
}
