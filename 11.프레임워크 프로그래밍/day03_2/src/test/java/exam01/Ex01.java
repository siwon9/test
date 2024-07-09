package exam01;

import config.AppCtx;
import member.entities.Member;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = AppCtx.class)
public class Ex01 {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    void test1() {
        String sql = "INSERT INTO MEMBER (SEQ, EMAIL, PASSWORD, USER_NAME) " +
                "VALUES (SEQ_MEMBER.NEXTVAL, ?, ?, ?)";
        int result = jdbcTemplate.update(sql, "user04@test.org", "1234", "siwon4");
        System.out.println(result);
    }

    @Test
    void test2() {
        List<Member> members  = jdbcTemplate.query("SELECT * FROM MEMBER", this::mapper
    //            (rs, num) -> mapper(rs,num) 이거보다 더 짧게쓰면 메서드 참조를해서 그냥 디스로 갈긴다.
    );
        members.forEach(System.out::println);
    }

    @Test
    void test3() {
        String email="user07@test.org";
        try {
            Member member = jdbcTemplate.queryForObject("SELECT * FROM MEMBER WHERE EMAIL =" +
                    "?", this::mapper, email);
            System.out.println(member);
        } catch(Exception e) {
            System.out.println("없음");
        }

    }

    @Test
    void test4() {
        int total = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM MEMBER", int.class);
        System.out.println(total);
    }

    private Member mapper(ResultSet rs, int num) throws SQLException{
        return Member.builder()
                .seq(rs.getLong("SEQ"))
                .email(rs.getString("EMAIL"))
                .password(rs.getString("PASSWORD"))
                .userName(rs.getString("USER_NAME"))
                .regDt(rs.getTimestamp("REG_DT").toLocalDateTime())
                .build();
    }
}


