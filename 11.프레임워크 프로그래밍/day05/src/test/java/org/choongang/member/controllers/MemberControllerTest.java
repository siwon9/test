package org.choongang.member.controllers;

import org.choongang.config.MvcConfig;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.Locale;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@SpringJUnitWebConfig
@ContextConfiguration(classes = MvcConfig.class)
public class MemberControllerTest {

    @Autowired // 다형성 때문에 WebApplicationContext를 사용한다. 뭐가들어올지 모르기때문
    private WebApplicationContext ctx;

    private MockMvc mockMvc;

    @BeforeEach
    void init() {
        mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
    }

    @Test
    void test1() throws Exception {
        mockMvc.perform(
                post("/member/join")
                        .header("appKey","1234") // 요청 헤더
                        .contentType(MediaType.APPLICATION_JSON_VALUE) // 상수형태로 쓰는게 오타를 줄일 수 있어 좋음
                )
                .andDo(print());
    }

    @Test
    void test2() throws Exception{
        mockMvc.perform(
                get("/member/join")
                        .header("Accept-Language", Locale.KOREAN.getLanguage())
                )
                .andDo(print());
    }
}
