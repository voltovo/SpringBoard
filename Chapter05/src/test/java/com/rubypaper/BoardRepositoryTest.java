package com.rubypaper;


import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import com.rubypaper.domain.Board;
import com.rubypaper.persistence.BoardRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BoardRepositoryTest {
	
	@Autowired
	private BoardRepository boardRepo;
	
	/* 등록 테스트
	 * @Test public void testInsertBoard() { Board board = new Board();
	 * board.setTitle("첫 번째 게시글"); board.setWriter("테스터");
	 * board.setContent("잘 등록되나요?"); board.setCreateDate(new Date());
	 * board.setCnt(0L);
	 * 
	 * 
	 * boardRepo.save(board); }
	 */
	
	/* 상세조회 테스트
	 * @Test public void testGetBoard() { Board board =
	 * boardRepo.findById(1L).get(); System.out.println(board.toString()); }
	 */
	
	/* 수정 테스트
	 * @Test public void testUpdateBoard() {
	 * System.out.println("=== 1번 게시글 조회 ==="); Board board =
	 * boardRepo.findById(1L).get();
	 * 
	 * System.out.println("=== 1번 게시글 제목 수정 ===="); board.setTitle("제목을 수정했다.");
	 * boardRepo.save(board); }
	 */
	
	/*
	 * //삭제 테스트
	 * 
	 * @Test public void testDeleteBoard() { boardRepo.deleteById(1L); }
	 */
	
	/*
	 * //페이징 테스트
	 * 
	 * @Test public void testFindByTitleContaining() { Pageable paging =
	 * PageRequest.of(0, 5);
	 * 
	 * List<Board> boardList = boardRepo.findByTitleContaining("제목", paging);
	 * 
	 * System.out.println("검색 결과"); for(Board board : boardList) {
	 * System.out.println("---> " + board.toString()); } }
	 */
	
	//정렬 테스트
	@Test
	public void testFindByTitleContaining() {
		Pageable paging = PageRequest.of(0, 5, Sort.Direction.DESC, "seq");
		
		List<Board> boardList = boardRepo.findByTitleContaining("제목", paging);
		
		System.out.println("검색 결과");
		for(Board board : boardList) {
			System.out.println("---> " + board.toString());
		}
	}
}
