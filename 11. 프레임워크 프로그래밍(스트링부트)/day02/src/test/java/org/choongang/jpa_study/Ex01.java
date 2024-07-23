package org.choongang.jpa_study;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.choongang.member.entities.Member;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@SpringBootTest
@Transactional
@TestPropertySource(properties = "spring.profiles.active=test") // 설정파일을 어떻게 가져올 것인지에 관하여
public class Ex01 {

    //@Autowired
    //private EntityManagerFactory emf;

    //@Autowired
    @PersistenceContext // 영속성 주입을 위한 어노테이션
    private EntityManager em; // 영속성 관리역할을 한다.

    @Test
    void test1() {
        //EntityManager em = emf.createEntityManager();// 상태변화에 따라서 쿼리가 자동실행되게 만든다.

        Member member = new Member();
        member.setSeq(1L);
        member.setEmail("user01@test.org");
        member.setPassword("12341234");
        member.setUserName("user01");
        member.setCreatedAt(LocalDateTime.now());

        em.persist(member); // 영속 상태 - 변화 감지 메모리에 있다, 변화감지중..

        em.flush(); // INSERT 쿼리 // flush는 DB반영임. 쿼리가 추가될거같을 때마다 flush를 써야할듯

        em.detach(member); // 영속 상태 분리 - 변화 감지 X

        member.setUserName("(수정)사용자01"); // 변경
        member.setModifiedAt(LocalDateTime.now());

        em.flush(); // UPDATE 쿼리 실행

        em.merge(member);

        em.flush();

       // em.remove(member); // 제거 상태, 제거 X, 상태만 제거
        //em.flush(); // DELETE 쿼리실행

        //tx.commit(); // 예외가 발생하면 롤백하는식으로 try catch써도 될듯
    }
}
