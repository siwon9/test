package exam01.member;

import exam01.member.dao.MemberDao;
import exam01.member.services.JoinService;
import exam01.member.validators.JoinValidator;

public class Assembler {

    public MemberDao memberDao() {
        return new MemberDao();
    }

    public JoinValidator joinValidator() {
        JoinValidator validator = new JoinValidator();
        validator.setMemberDao(memberDao());
        return validator;
    }

    //여기다가만 추가하면 알아서 다바뀐다. 통제하기위해서 여기를 솔리드공부하고 다시보면 좋을거같다.
    public JoinService joinService() {
        return new JoinService(joinValidator(), memberDao());
        //return new JoinService();
    }
}
