package exam01;

import org.junit.jupiter.api.Test;

public class Ex01 {

    @Test
    void test1() {
        Member member = new Member();
        member.setUserId("USER01");
        member.setUserNm("siwon");
        System.out.println(member);
    }

}
