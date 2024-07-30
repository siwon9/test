package org.siwon.board.services;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.siwon.board.controllers.RequestBoard;
import org.siwon.board.entities.Board;
import org.siwon.board.exceptions.BoardNotFoundException;
import org.siwon.board.repositories.BoardRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BoardInfoService {
    private final BoardRepository boardRepository;

    public Board get(Long seq) {
        Board board = boardRepository.findById(seq).orElseThrow(BoardNotFoundException::new);

        // 2차 데이터 가공 처리

        return board;
    }

    public RequestBoard getForm(Long seq) {
        Board board = get(seq);
        RequestBoard form = new ModelMapper().map(board,RequestBoard.class);

        // 2차 처리 수정

        return form;
    }
}
