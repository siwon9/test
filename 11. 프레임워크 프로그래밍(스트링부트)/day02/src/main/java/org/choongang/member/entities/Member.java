package org.choongang.member.entities;

import jakarta.persistence.*;
import lombok.Data;
import org.choongang.member.constants.Authority;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Data
@Entity
//@Table(name="CH_MEMBER")
/*
@Table(indexes = {
        @Index(name="idx_created_at_desc", columnList = "createdAt DESC"),
        @Index(name="uq_email_passsword", columnList = "email, password", unique = true)
})*/
public class Member {
    @Id @GeneratedValue//(strategy = GenerationType.AUTO)가 디폴트 값.
    private Long seq;
    private String email;
    private String password;
    private String userName;

    //@Lob // 여러줄 써야할 때
    @Transient // 내부적으로 쓸 목적이다. file.info를 보면 감을 잡을 수 있다.
    private String introduction;

    @Enumerated(EnumType.STRING)
    private Authority authority;

    @CreationTimestamp
    private LocalDateTime createdAt;
    @UpdateTimestamp // 둘다 기본값이 들어가진 않는다.
    private LocalDateTime modifiedAt;
}