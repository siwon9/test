package org.siwon.board.services;

import lombok.RequiredArgsConstructor;
import org.siwon.board.controllers.RequestBoard;
import org.siwon.board.entities.Board;
import org.siwon.board.repositories.BoardRepository;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class BoardSaveService {

    private final BoardRepository boardRepository;

    public void save(RequestBoard form) {
        Long seq = Objects.requireNonNullElse(form.getSeq(), 0L);
        Board board = boardRepository.findById(seq).orElseGet(Board::new);

        board.setSubject(form.getSubject());
        board.setContent(form.getContent());
        board.setPoster(form.getPoster());

        boardRepository.saveAndFlush(board);

    }
}
