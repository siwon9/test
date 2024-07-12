package org.choongang.member.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j // 이거하면 밑에 로그가 만들어진다.
@Controller
@RequestMapping("/member")
public class MemberController {

    @GetMapping("/join")
    public String join() {

        return "member/join";
    }

    @PostMapping("/join")
    public String joinPs(RequestJoin form) {

        log.info(form.toString());

        return "member/join";
    }
    // 쓸걸 미리 알고있기 때문에 바로 EL식으로 접근이 가능하다

    @GetMapping("/login")
    public String login() {

        return "member/login";
    }
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



