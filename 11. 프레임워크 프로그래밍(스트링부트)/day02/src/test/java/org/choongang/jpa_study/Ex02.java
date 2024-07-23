package org.choongang.jpa_study;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.choongang.member.entities.Member;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@SpringBootTest
@TestPropertySource(properties = "spring.profiles.active=test")
@Transactional
public class Ex02 {

    @PersistenceContext
    private EntityManager em;

    @BeforeEach
    void init() {
        for(long i=1; i <=10L; i++) {
            Member member = new Member();
            member.setSeq(i);
            member.setEmail("user" + i + "@test.org");
            member.setPassword("12341234");
            member.setUserName("user"+i);
            member.setCreatedAt(LocalDateTime.now());
            em.persist(member); // 영속 상태
        }

        em.flush(); // DB 영구 반영
        em.clear(); // 영속 상태 엔티티 모두 비우기
    }

    @Test
    void test1() {
        Member member =em.find(Member.class, 1L);
        System.out.println(member);

        Member member2 = em.find(Member.class, 1L);
        System.out.println(member2);

        System.out.println(member == member2);
        System.out.println("member:" + System.identityHashCode(member));
        System.out.println("member2:" + System.identityHashCode(member2));

        member.setUserName("(수정)사용자1");
        //em.flush(); // UPDATE 쿼리 수행
        // 값을 바꾸고 조회를 하면 암묵적으로 flush가 진행된다.
        Member member3 = em.find(Member.class, 1L);
        System.out.println(member3);
    }
}



