package org.choongang.global.board.repositories;

import org.choongang.global.board.entities.BoardData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface BoardDataRepository extends JpaRepository<BoardData, Long>,
        QuerydslPredicateExecutor<BoardData> {

}
