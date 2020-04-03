package com.rubypaper.persistence;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.rubypaper.domain.Board;

public interface BoardRepository extends CrudRepository<Board, Long> {
	//목록 검색 쿼리 메소드
	List<Board> findByTitle(String searchKeyword);
	//like 쿼리 메소드
	List<Board> findByContentContaining(String searchkeyword);
	//여러 조건 메소드
	List<Board> findByTitleContainingOrContentContaining(String title, String content);
	//데이터 정렬 메소드
	List<Board> findByTitleContainingOrderBySeqDesc(String searchkeyword);
	/*
	 * //페이징 메소드 List<Board> findByTitleContaining(String searchkeyword, Pageable
	 * paging);
	 */
	//페이징 메소드 리턴 타입 변경
	Page<Board> findByTitleContaining(String searchkeyword, Pageable paging);
	
	//위치기반 파라미터 사용하기
	@Query("SELECT b FROM Board b WHERE b.title like %?1% ORDER BY b.seq DESC")
	List<Board> queryAnnotationTest1(String searchkeyword);
	
	//이름 기반 파라미터 사용하기
	@Query("SELECT b FROM Board b WHERE b.title like %:searchkeyword% ORDER BY b.seq DESC")
	List<Board> queryAnnotationTest2(@Param("searchkeyword") String searchkeyword);
	
	//특정 변수만 조회하기
	@Query("SELECT b.seq, b.title, b.writer, b.createDate FROM Board b WHERE b.title like %?1% ORDER BY b.seq DESC")
	List<Object[]> queryAnnotationTest3(@Param("searchkeyword") String searchkeyword);
	
}
