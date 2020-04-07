package com.rubypaper.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rubypaper.domain.Board;
import com.rubypaper.persistence.BoardRepository;

@Service
public class BoardServiceImpl {
	
	@Autowired
	private BoardRepository boardRepo;
	
	//테이블의 모든 데이터를 가지고와서 리턴
	public List<Board> getBoaList(Board board){
		return (List<Board>) boardRepo.findAll();
	}
	
	public void insertBoard(Board board) {
		
	}
	
	public Board getBoard(Board board) {
		return null;
	}
	
	public void updateBoard(Board board) {
		
	}
	
	public void deleteBoard(Board board) {
		
	}
}
