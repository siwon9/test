package exam01;

import configs.DBConn;
import member.Member;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

public class Ex02 {

    private SqlSession session = DBConn.getSession();
    @Test
    void test1() {
        Member member = Member.builder()
                .userId("USER" + System.currentTimeMillis())
                .userPw("123456")
                .userNm("사용자,,")
                .mobile("01000000000")
                .build();

        int cnt = session.insert("mappers.MemberMapper.register", member);
        System.out.println(cnt);
    }
}
