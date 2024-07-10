package configs;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc // 원래 작성해야하는 설정들을 자동 작성해주는 애노테이션
@ComponentScan("member")
@Import(DBConfig.class)
public class MvcConfig implements WebMvcConfigurer { // WebMvc 설정의 틀이다.
    @Override // 기본 경로 처리에 대한 부분들
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    @Override // 반환값에 따라 출력할 템플릿(뷰 객체)을 찾아주는 역할이다.
    public void configureViewResolvers(ViewResolverRegistry registry) {
      registry.jsp("/WEB-INF/templates/", ".jsp");
    }
}
