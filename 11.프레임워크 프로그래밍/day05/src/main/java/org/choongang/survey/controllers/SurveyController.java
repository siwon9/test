package org.choongang.survey.controllers;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

@Slf4j // @Slf4j는 Lombok 라이브러리에서 제공하는 어노테이션으로, 로그를 쉽게 사용할 수 있도록 도와줌
@Controller
@RequestMapping("/survey")
@SessionAttributes("requestSurvey") // 값을 유지해주기 위해서 쓰는 속성인데 , hidden 값은 번거로울 수 있음
public class SurveyController {

    @ModelAttribute
    public RequestSurvey requestSurvey() { // 이렇게 추가해야 사용할 수 있다?
        return new RequestSurvey();
    }

    @GetMapping("/step1")
    public String step1() { //여기서 매개변수가 원래 RequestSurvey였는데 위에 정의하고 나선 안써도 되는이유는?

        return "survey/step1";
    }

    @PostMapping("/step2")
    public String step2(RequestSurvey form,
                        @SessionAttribute("requestSurvey") RequestSurvey form2) { //세션쪽에서 가져온 값

        log.info("form : " + form.toString()); //Slf4j 기능임
        log.info("form2 : " + form2.toString());

        return "survey/step2";
    }

    @PostMapping("/step3")
    public String step3(RequestSurvey form, @SessionAttribute("requestSurvey") RequestSurvey form2
            , SessionStatus status, HttpServletRequest request) {

        log.info("form : " + form.toString());
        log.info("form2 : " + form2.toString());

        status.setComplete(); // 세션 비우기 - requestSurvey 세션 비우기

        System.out.println("세션 비우기 후 :" + request.getAttribute("requestSurvey"));

        return "survey/step3";
    }
}