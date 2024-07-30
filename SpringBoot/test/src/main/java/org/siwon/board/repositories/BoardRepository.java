package org.siwon.board.repositories;

import org.siwon.board.entities.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface BoardRepository extends JpaRepository<Board, Long>,
        QuerydslPredicateExecutor<Board> {

}
