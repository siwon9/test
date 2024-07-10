package mappers.member;

import member.entities.Member;
import org.apache.ibatis.annotations.Select;

public interface MemberMapper {
    @Select("SELECT COUNT(*) FROM MEMBER") // 간단한 쿼리는 이렇게 사용가능, 복잡하면 Mapper에 추가
    long getTotal();

    int register(Member member);
    Member get(String email);
    int exists(String email);

}
