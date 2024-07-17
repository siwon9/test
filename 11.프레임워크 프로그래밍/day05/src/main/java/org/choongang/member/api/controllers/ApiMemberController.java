package org.choongang.member.api.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.choongang.member.controllers.RequestJoin;
import org.choongang.member.entities.Member;
import org.choongang.member.mappers.MemberMapper;
import org.choongang.member.services.JoinService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.IntStream;

@Slf4j
@RestController
@RequestMapping("/api/member")
@RequiredArgsConstructor
public class ApiMemberController {

    private final MemberMapper mapper;
    private final JoinService joinService;

    @PostMapping
    public ResponseEntity join(@RequestBody RequestJoin form) {
        joinService.process(form);

        //응답 코드 201, 출력 바디 X
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/info/{email}")
    public Member info(@PathVariable("email") String email) {
        // Content-Type: application/json

        Member member = mapper.get(email);

        return member;
    }

    @GetMapping("/list")
    public ResponseEntity<List<Member>> list() {
        List<Member> members = IntStream.rangeClosed(1, 10)
                .mapToObj(i -> Member.builder()
                        .email("user" + i + "@test.org")
                        .password("12345678")
                        .userName("사용자" + i)
                        .regDt(LocalDateTime.now())
                        .build())
                .toList();

        HttpHeaders headers = new HttpHeaders(); // 응답 헤더
        headers.add("t1", "v1");
        headers.add("t2", "v2");

        //return ResponseEntity.status(HttpStatus.OK).body(members);
            // 응답을 상세하게 설정할 때 사용된다.
        return new ResponseEntity<>(members, headers, HttpStatus.OK);
    }

    @GetMapping(path="/test", produces = "text/html;charset=UTF-8") // "text/html;charset=UTF-8", MediaType.APPLICATION_JSON_VALUE
    public String test() {
        // Content-Type: text/plain
        return "안녕하세요!";
    }

    @GetMapping("/test2")
    public void test2() {
        log.info("test2...");

    }
}
