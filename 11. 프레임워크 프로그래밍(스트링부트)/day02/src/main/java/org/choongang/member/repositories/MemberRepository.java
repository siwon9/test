package org.choongang.member.repositories;

import org.choongang.member.entities.Member;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Long>,
        QuerydslPredicateExecutor<Member> { //
    Member findByEmail(String email); // Optional 형태도 가능하다.

    Page<Member> findByEmailContaining(String keyword, Pageable pageable);

    List<Member> findByEmailContainingAndUserNameContainingOrderByCreatedAtDesc(String key1,
       String key2);

    @Query("SELECT m FROM Member m WHERE m.email LIKE :k1 AND m.userName Like :k2 ORDER BY " +
            "m.createdAt DESC") // 코드상에는 오류가 있는지 없는지 모른다. 실행해봐야 알 수 있다. 직접쓰는건 지양
    List<Member> getMembers(@Param("k1")String key1,@Param("k2") String key2);
}

