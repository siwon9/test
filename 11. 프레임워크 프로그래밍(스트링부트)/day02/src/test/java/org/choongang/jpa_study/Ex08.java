package org.choongang.jpa_study;

import jakarta.persistence.EntityManager;
import jakarta.persistence.FlushModeType;
import jakarta.persistence.PersistenceContext;
import org.choongang.member.constants.Authority;
import org.choongang.member.entities.Member;
import org.choongang.member.repositories.MemberRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
@ActiveProfiles("test") // 테스트쪽 프로파일을 가져올 수 있다.
@Transactional
public class Ex08 {
    @PersistenceContext // 의존성 주입인데 뭔지 잘 모르겠다.
    private EntityManager em;

    @Autowired
    private MemberRepository memberRepository;

    @BeforeEach
    void init() {
        em.setFlushMode(FlushModeType.AUTO);

        //자동으로 시퀀스번호 작성되게 해놔서 여기서 주입하면 오류난다.
        Member member = Member.builder()
                .email("user01@test.org")
                .password("12345678")
                .userName("사용자01")
                .authority(Authority.USER)
                .build();

        memberRepository.saveAndFlush(member);

        em.clear();
    }

    @Test
    void test1() {
        Member member = memberRepository.findById(1L).orElse(null);

        member.setUserName("테스트!!!");

        List<Member> members = memberRepository.findAll();
        members.forEach(System.out::println);

        em.clear();

        List<Member> members2 = memberRepository.findAll();
        members.forEach(System.out::println);
    }
}