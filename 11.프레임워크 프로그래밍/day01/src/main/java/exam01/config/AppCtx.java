package exam01.config;

import exam01.Greeter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

//설정 클래스 - 스프링 컨터이너가 관리할 객체를 정의, 설정
@Import(AppCtx2.class)
@Configuration // @Bean 있는지 없는지 확인하는거
public class AppCtx {

    @Bean
    public Greeter greeter() {
        return new Greeter();
    }
}
