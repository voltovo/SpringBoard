package com.rubypaper.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rubypaper.domain.Board;
import com.rubypaper.persistence.BoardRepository;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardRepository boardRepo;
	
	//테이블의 모든 데이터를 가지고와서 리턴
	@Override
	public List<Board> getBoaList(Board board){
		return (List<Board>) boardRepo.findAll();
	}
	
	@Override
	public void insertBoard(Board board) {
		
	}
	
	@Override
	public Board getBoard(Board board) {
		return null;
	}
	
	@Override
	public void updateBoard(Board board) {
		
	}
	
	@Override
	public void deleteBoard(Board board) {
		
	}
}
