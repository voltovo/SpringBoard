package com.rubypaper.board.persistence;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.rubypaper.board.domain.Board;

public interface BoardRepository extends CrudRepository<Board, Long>{
	
	//글 목록 검색하는 메소드
	//페이징 처리와 정렬을 위해서 Pageable
	//다양한 정보를 웹 페이지에서 사용하기 위해서 리턴타입을 List가 아닌 Page로
	@Query("SELECT b from Board b")
	Page<Board> getBoardList(Pageable pageable);
}
