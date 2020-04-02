package com.rubypaper.persistence;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.rubypaper.domain.Board;

public interface BoardRepository extends CrudRepository<Board, Long> {
	//목록 검색 쿼리 메소드
	List<Board> findByTitle(String searchKeyword);
	//like 쿼리 메소드
	List<Board> findByContentContaining(String searchkeyword);
	//여러 조건 사용
	List<Board> findByTitleContainingOrContentContaining(String title, String content);
}
