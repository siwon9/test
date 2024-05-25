package mappers;

import member.Member;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface MemberMapper {
    List<Member> getList();

    @Select("SELECT * FROM MEMBER")
    List<Member> getList2();
}