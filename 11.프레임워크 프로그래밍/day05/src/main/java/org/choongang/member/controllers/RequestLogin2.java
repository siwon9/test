package org.choongang.member.controllers;

import lombok.Builder;

@Builder
public record RequestLogin2(
        String email, String password
)//자료형을 매개변수로 입력한다.
 { }
