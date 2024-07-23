package org.choongang.member.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity // 관리되는 데이터로써 인식하게 된다. 테이블이 이 클래스내용을 바탕으로 만들어진다.
public class Member {
    @Id // jakarta 패키지 id로 설정, seq를 기본값으로 설정.
    private Long seq;
    private String email;
    private String password;
    private String userName;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
}
