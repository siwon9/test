package org.choongang.global.board.entities;

import jakarta.persistence.*;
import lombok.*;
import org.choongang.global.entities.BaseEntity;
import org.choongang.member.entities.Member;

@Data
@Entity // 테이블에 대응하는 클래스
@Builder
@AllArgsConstructor @NoArgsConstructor
public class BoardData extends BaseEntity {

    @Id @GeneratedValue
    private Long seq;

    @ManyToOne(fetch = FetchType.LAZY) //
    @JoinColumn(name="mSeq") // 외래래 키가 있는 컬럼을 정의하고, 그 컬럼이 참조하는 테이블의 기본 키를 설정
    private Member member;

    @Column(nullable = false)
    private String subject;

    @Lob // 여러줄 쓸 때 사용됨.
    private String content;

    // @ManyToMany
    // private List<HashTag> tags;
}
