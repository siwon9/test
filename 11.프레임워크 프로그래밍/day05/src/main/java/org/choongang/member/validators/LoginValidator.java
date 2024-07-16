package org.choongang.member.validators;

import lombok.RequiredArgsConstructor;
import org.choongang.member.controllers.RequestLogin;
import org.choongang.member.entities.Member;
import org.choongang.member.mappers.MemberMapper;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
@RequiredArgsConstructor
public class LoginValidator implements Validator {

    private final MemberMapper mapper;

    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.isAssignableFrom(RequestLogin.class);
    } // 이 클래스로부터 유래된 클래스들만 적용된다. (유입되는 자료형을 한정한다.)

    @Override
    public void validate(Object target, Errors errors) {

        // Bean Validation 검증 실패시에는 다음 검증을 진행 하지 않게하는 방법이다.
        if(errors.hasErrors()) {
            return;
        }

        RequestLogin form = (RequestLogin) target;
        String email = form.getEmail();
        String password = form.getPassword(); // 사용자가 입력한 비밀번호

        if(StringUtils.hasText(email)){
            Member member = mapper.get(email);
            if(member == null) {
                //errors.rejectValue("email", "Check.emailPassword");
                errors.reject("Check.emailPassword");
            }


            if(member != null && StringUtils.hasText(password) && !BCrypt.checkpw(password, member.getPassword())) {
                //errors.rejectValue("password", "Check.emailPassword");
                errors.reject("Check.emailPassword");
            }

        }
    }
}
