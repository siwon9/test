package org.siwon.board.controllers;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class RequestBoard { // 커맨드 객체

    private Long seq;
    @NotBlank
    private String poster;
    @NotBlank
    private String subject;
    @NotBlank
    private String content;
}


