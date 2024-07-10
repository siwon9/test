package member.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller // 역할이 웹으로 특정 되어있는 빈으로 만들어진다.
public class MemberController {

    @GetMapping("/member/join")
    public String join(@RequestParam(value = "name", defaultValue = "기본값") String name) { //여기도 다시 한번 공부

        System.out.println("name : " +name);
        return "member/join";
    }

    @PostMapping("/member/join")
    public String joinPs(RequestJoin form) { // RequestJoin 이 커멘드 객체이다.? 이쪽 공부다시해야함 3시45분쯤 부터
        System.out.println(form);

        return "member/join";
    }
}

