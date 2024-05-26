package exam01;

import configs.DBConn;
import member.Member;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Ex01 {
    SqlSession session = DBConn.getSession();
    List<Member> members = session.selectList("mappers.MemberMapper.getList");

    @Test
    void test2(){
        SqlSession session = DBConn.getSession();
        MemberMapper mapper = session.getMapper(MemberMapper.class);
        List<Member> members = mapper.getList();
        members.forEach(System.out::println);
    }
}

