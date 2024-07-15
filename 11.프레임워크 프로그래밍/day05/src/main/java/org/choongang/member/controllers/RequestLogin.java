package org.choongang.member.controllers;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class RequestLogin { // 커멘드 객체
    @NotBlank
    private String email;
    @NotBlank
    private String password;

    private boolean saveEmail;
}
