package org.choongang.member.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.choongang.global.entities.BaseEntity;
import org.choongang.member.constants.Authority;

@Builder
@Data
@Entity
@NoArgsConstructor @AllArgsConstructor
//@Table(name="CH_MEMBER")
/*
@Table(indexes = {
        @Index(name="idx_created_at_desc", columnList = "createdAt DESC"),
        @Index(name="uq_email_passsword", columnList = "email, password", unique = true)
})*/
public class Member extends BaseEntity {

    @Id @GeneratedValue//(strategy = GenerationType.AUTO)가 디폴트 값.
    private Long seq;

    @Column(length = 60, nullable=false, unique = true)
    private String email;

    @Column(length= 65, nullable = false)
    private String password;

    @Column(length = 40, nullable=false,name = "name") // db테이블은 name으로 연결되어있다.
    private String userName;

    //@Lob // 여러줄 써야할 때
    @Transient // 내부적으로 쓸 목적이다. file.info를 보면 감을 잡을 수 있다.
    private String introduction;

    @Column(length = 10)
    @Enumerated(EnumType.STRING)
    private Authority authority;

}
