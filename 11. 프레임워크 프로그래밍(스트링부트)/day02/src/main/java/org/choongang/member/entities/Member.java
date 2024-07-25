package org.choongang.member.entities;

import jakarta.persistence.*;
import lombok.*;
import org.choongang.global.board.entities.BoardData;
import org.choongang.global.entities.BaseEntity;
import org.choongang.member.constants.Authority;

import java.util.List;

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

    @OneToOne
    @JoinColumn(name="profile_seq")
    private MemberProfile profile;

    @ToString.Exclude // ToString 추가 배제 , 상관관계를 이해하고 어디에 추가로 배제해야 하는지 생각해보자
    @OneToMany(mappedBy = "member") // 이거 넣어야하는 이유가 뭔데?
    private List<BoardData> items;
}
