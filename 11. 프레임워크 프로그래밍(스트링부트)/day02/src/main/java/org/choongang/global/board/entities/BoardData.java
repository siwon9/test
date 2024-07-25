package org.choongang.global.board.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.choongang.global.entities.BaseEntity;
import org.choongang.member.entities.Member;

@Data
@Entity
@Builder
@AllArgsConstructor @NoArgsConstructor
public class BoardData extends BaseEntity {
    @Id @GeneratedValue
    private Long seq;

    @ManyToOne // member_seq  이 에노테이션만 붙여도 외래키를 만들어진다. - 엔티티명_기본키 속성명 으로 만들어짐
    @JoinColumn(name="mSeq") // M_SEQ 로 만들어진다.
    private Member member;

    @Column(nullable = false)
    private String subject;

    @Lob // 여러줄 쓸 때 사용됨.
    private String content;
}
