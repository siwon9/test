package member;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor(access= AccessLevel.PRIVATE)

public class Member {
    private String userId;
    private String userNm;
    private String email;
    private LocalDateTime regDt;
}
