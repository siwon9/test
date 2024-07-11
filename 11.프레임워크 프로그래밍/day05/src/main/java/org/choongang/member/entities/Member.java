package org.choongang.member.entities;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

@Data
@Builder
public class Member {
    @Id // 엔티티 클래스의 기본 키(primary key)를 지정
    private long seq;
    private String email;
    private String password;
    private String userName;
    private LocalDateTime regDt;
}
