package exam01;

import config.AppCtx;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.sql.PreparedStatement;

@Transactional // sql 쿼리를 한번에 많이 입력할 때 사용됨. 무조건 롤백
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = AppCtx.class)
public class Ex01 {

    @Autowired // test일 때는 final을 쓸 수 없다.
    private JdbcTemplate jdbcTemplate;

    // 람다로 줄이기
    @Test
    void test1() {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        int result = jdbcTemplate.update( con -> {
                String sql = "INSERT INTO MEMBER (SEQ, EMAIL, PASSWORD, USER_NAME) " +
                        "VALUES (SEQ_MEMBER.NEXTVAL, ?, ?, ?)";

                PreparedStatement pstmt = con.prepareStatement(sql, new String[] {"SEQ"});
                pstmt.setString(1,"user07@test.org");
                pstmt.setString(2,"123");
                pstmt.setString(3,"user7");

                return pstmt;
        }, keyHolder);

        System.out.println(result);
        Number key = keyHolder.getKey(); // SEQ 값을 long일지 int일지 모르기 때문에 가장 상위클래스인 Number로 설정됨
        long seq = key.longValue();
        System.out.println(seq);
    } // rollback이 어디임?
}

