package org.choongang.member.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Member {
    @Id // 엔티티 클래스의 기본 키(primary key)를 지정
    private Long seq; // 지네릭 타입에는 일반자료형을 사용할 수 없기 때문이다. 어짜피 형변환 될거면 Wrapper클래스로 한다.
    private String email;

    @JsonIgnore
    private String password;
    private String userName;

    // @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime regDt;
}
