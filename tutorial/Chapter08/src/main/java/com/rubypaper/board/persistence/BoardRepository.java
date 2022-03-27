package com.rubypaper.board.persistence;

import com.rubypaper.board.domain.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Map;

public interface BoardRepository extends CrudRepository<Board, String> {
    @Query("SELECT b FROM Board b")
    Page<Board> getBoardList(Pageable pageable);

    @Query("SELECT b FROM Board b WHERE b.seq = ?1")
    Board findById(long id);
}