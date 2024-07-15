package org.choongang.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.*;

@Configuration
@EnableWebMvc
@ComponentScan("org.choongang")
@Import({DBConfig.class, MessageConfig.class})
//@RequiredArgsConstructor
public class MvcConfig implements WebMvcConfigurer { // MVC 설정을 모아주는 클래스
    /*
    private final JoinValidator joinValidator; // 동작을 위한 예시로 필드 작성

    //모든 컨트롤러에 적용될 수 있는 전역 Validator
    @Override
    public Validator getValidator() {
        return joinValidator;
    }
     */

    @Override
    public void configureDefaultServletHandling
            (DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    @Override // 초반에 작업할 때 사용하게 된다.
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**")  // **는 모든경로를 의미한다.
                .addResourceLocations("classpath:/static/");
    }

    @Override
    public void configureViewResolvers
            (ViewResolverRegistry registry) {
        registry.jsp("/WEB-INF/templates/", ".jsp" );
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/")
                .setViewName("main/index");

        registry.addViewController("/mypage/**")
                .setViewName("mypage/index");
    }
}
