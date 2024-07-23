package org.choongang.jpa_study;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import org.choongang.member.entities.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.time.LocalDateTime;

@SpringBootTest
@TestPropertySource(properties = "spring.profiles.active=test") // 설정파일을 어떻게 가져올 것인지에 관하여
public class Ex01 {

    @Autowired
    private EntityManagerFactory emf;

    @Test
    void test1() {
        EntityManager em = emf.createEntityManager();// 상태변화에 따라서 쿼리가 자동실행되게 만든다.

        EntityTransaction tx = em.getTransaction();
        // transaction안에서 작업을 해줘야 작동이된다.

        tx.begin(); // Transaction 시작
        Member member = new Member();
        member.setSeq(1L);
        member.setEmail("user01@test.org");
        member.setPassword("12341234");
        member.setUserName("user01");
        member.setCreatedAt(LocalDateTime.now());

        em.persist(member);

        em.flush(); // 이게 뭘까

        tx.commit(); // 예외가 발생하면 롤백하는식으로 try catch써도 될듯
    }
}
