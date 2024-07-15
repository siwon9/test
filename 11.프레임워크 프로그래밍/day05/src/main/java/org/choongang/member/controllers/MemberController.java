package org.choongang.member.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.choongang.member.services.JoinService;
import org.choongang.member.validators.JoinValidator;
import org.choongang.member.validators.LoginValidator;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {

    private final JoinValidator joinValidator;
    private final JoinService joinService;

    private final LoginValidator loginValidator;

    @GetMapping("/join")
    public String join(@ModelAttribute RequestJoin form) { // 첫글자가 소문자로 바뀌어서 속성 추가된다.

        return "member/join";
    }

    @PostMapping("/join")
    public String joinPs(@Valid RequestJoin form, Errors errors) {
        // 커맨드객체 앞에 Valid를 붙여줘야 검증을 해줌 실패했을때 errors, 커멘드객체 뒤에 반드시 에러가 나와야 한다. 아니면 인식하지 못함.

        joinValidator.validate(form, errors); // 위에서 커버하지 못하는 부분만 여기서 커버한다.
        if (errors.hasErrors()) { // reject, rejectValue가 한번이라도 호출되면 true

            return "member/join";
        }

        joinService.process(form); // 회원 가입 처리

        return "redirect:/member/login";

    }

    @GetMapping("/login")
    public String login(@ModelAttribute RequestLogin form) {

        return "member/login";
    }


    @PostMapping("/login")
    public String loginPs(@Valid RequestLogin form, Errors errors) {

        loginValidator.validate(form, errors);
        if(errors.hasErrors()) {
            return "member/login";
        }

        return "redirect:/";
    }
    /*
    @InitBinder // 이 컨트롤러 안에서만 사용할 수 있는 Validator이다.
    public void initBinder(WebDataBinder binder) {
        binder.setValidator(joinValidator);
    }
     */
}