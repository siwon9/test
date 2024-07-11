package org.choongang.member.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member")
public class MemberController {

   // @GetMapping("/member/join")
//    @RequestMapping(path="/member/join", method = {RequestMethod.GET, RequestMethod.POST})
//    public String join(Model model, HttpServletRequest request) {
//
//        model.addAttribute("message", "Hello world");
//        System.out.println("method : " + request.getMethod());
//
//        return "member/join";
//    }

    @GetMapping("/join")
    public String join() {

        return "/member/join";
    }

    @PostMapping("/join")
    public String joinPs(RequestJoin form) {

        return"redirect:/member/login" ;
    }

//    @GetMapping("/member/join") // 똑같다.
//    public ModelAndView join(){
//        ModelAndView mv = new ModelAndView();
//        mv.addObject("message", "Hello world");
//        mv.setViewName("member/join");
//
//        return mv;
//    }
}



