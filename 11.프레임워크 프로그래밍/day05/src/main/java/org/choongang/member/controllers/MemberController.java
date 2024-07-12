package org.choongang.member.controllers;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Locale;

@Slf4j // 이거하면 밑에 로그가 만들어진다.
@Controller
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {

    private final MessageSource messageSource;
    private final HttpServletRequest request;

    @ModelAttribute("commonValue")
    public String commonValue() {
        return "공통 속성값...";
    }

    @ModelAttribute("hobbies")
    public List<String> hobbies() {
        return List.of("취미1", "취미2", "취미3", "취미4");
    }

    @ModelAttribute("hobbies2")
    public List<CodeValue> hobbies2() {
        return List.of(
            new CodeValue("취미1", "hobby1"),
            new CodeValue("취미2", "hobby2"),
            new CodeValue("취미3", "hobby3"),
            new CodeValue("취미4", "hobby4")
        );
    }

    @GetMapping("/join")
    public String join(@ModelAttribute RequestJoin form) {
        // 속성이 없으면 새로 만들어준다.
        // 클래스명에서 앞자만 소문자로 바뀐걸로 바뀌는데 그 이름으로 속성명이 만들어진다.
        // 입력하지 않으면 기본적으로 'command' 임

        Locale locale = request.getLocale(); // 요청 헤더 Accept-Language
        String message = messageSource.getMessage("EMAIL", null, locale);
        log.info(message);

        return "member/join";
    }

    @PostMapping("/join")
    public String joinPs(@ModelAttribute RequestJoin form) { // 커멘드 객체이다. RequestJoin

        log.info(form.toString());

        return "member/join";
    }
    // 쓸걸 미리 알고있기 때문에 바로 EL식으로 접근이 가능하다

    @GetMapping("/login")
    public String login(RequestLogin2 form) {
        if(form != null) {
            log.info("이메일:{}, 비밀번호: {}", form.email(), form.password());
        }
        return "member/login";
    }
/*
    @GetMapping("/join")
    public String join(Model model) { // 스프링은 주로 모델을가지고 설정을한다.

        RequestJoin form = new RequestJoin();
        model.addAttribute("requestJoin", form); // 매번생성해야하기 떄문에 빈으로 만들면 안된다.

        return "member/join";
    }
*/
    //레벨별로 메서드가 존재한다.
   // private final Logger log = LoggerFactory.getLogger(MemberController.class);

    /*
    @PostMapping("/join")
    public String joinPs(RequestJoin form) {

        return "forward:/member/login";
        //return "redirect:/member/login"; // Location: /day05/member/login
    }       // 앞에 redirect: 할때 /가 있으면 절대경로이다.(contextPath가 붙는다.)
*/
    /*
    @GetMapping("/join")
    public String join1() {
        log.info("{}, {} 없음", "mode1", "mode2");
        return "member/join";
    }
*/
   /*
    @GetMapping(path="/join", params={"mode=join"}) // value는 생략가능하다.
    //params - 특정 파라미터 값을 한정할 때 쓰인다.
    public String join() {
        log.info("mode=join");
        return "/member/join";
    }

    @PostMapping(path="/join", headers = "appKey=1234", consumes = MediaType
            .APPLICATION_JSON_VALUE, produces = MediaType
            .APPLICATION_JSON_VALUE)
    public String joinPs(RequestJoin form) {

        log.info("joinPs 실행...");

        return"redirect:/member/login" ;

    }
*/
//    @GetMapping("/member/join") // 똑같다.
//    public ModelAndView join(){
//        ModelAndView mv = new ModelAndView();
//        mv.addObject("message", "Hello world");
//        mv.setViewName("member/join");
//
//        return mv;
//    }
}



