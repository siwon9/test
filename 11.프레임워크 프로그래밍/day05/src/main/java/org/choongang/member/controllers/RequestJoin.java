package org.choongang.member.controllers;

import lombok.Data;

@Data
public class RequestJoin {
    private String email;
    private String password;
    private String confirmPassword;
    private String userName;
    // private String[] hobby;
    // private Set<String> hobby;
    // private List<String> hobby;   //이거는 리스트라 mutiple형태로 나오고
    private String hobby; // 이거는 한개씩 선택할 수 있게 나온다.

    private boolean agree;

    private Address addr;

}
