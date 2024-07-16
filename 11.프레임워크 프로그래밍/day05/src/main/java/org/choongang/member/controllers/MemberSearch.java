package org.choongang.member.controllers;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
public class MemberSearch {
    @DateTimeFormat(pattern = "yyyyMMdd" ) // 타입에 맞지않게 입력하면 익셉션 발생
    private LocalDate sDate; // 검색 시작일

    @DateTimeFormat(pattern = "yyyyMMdd" )
    private LocalDate eDate; // 검색 종료일
}
