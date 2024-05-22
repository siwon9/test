package member;

import lombok.*;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
//@NoArgsConstructor(access= AccessLevel.PRIVATE)
@NoArgsConstructor
@RequiredArgsConstructor

public class Member {
    @NonNull
    private String userId;
    @NonNull
    private String userNm;
    private String email;
    @ToString.Exclude
    private LocalDateTime regDt;
}
