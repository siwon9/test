package config;

import board.services.BoardService2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
//자동 스캔되는 빈을 배제하는 두가지 방법
/*
@ComponentScan(basePackages="member",
    excludeFilters = @ComponentScan.Filter(type= FilterType.ANNOTATION, classes= ManualBean.class)
) // @ManualBean이  붙어있는 클래스는 배제가 된다.
 */
/*
@ComponentScan(basePackages = "member",
        excludeFilters = @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE,
        classes = {MemberDao.class, JoinValidator.class})
)       // 직접 배제할 클래스를 명시해도 가능하다.

 */
// 정규표현식으로 가능하다.
/*
@ComponentScan(basePackages = "member",
    excludeFilters = @ComponentScan.Filter(type= FilterType.REGEX,
            pattern = "member\\.*\\w*Dao")
)
 */
/*
@ComponentScan(basePackages = {"member","board"},
excludeFilters = @ComponentScan.Filter(type = FilterType.ASPECTJ,
        pattern="member..*Dao")
)
 */
@ComponentScan({"member", "board"})
public class AppCtx {



    @Scope("prototype") // 매번 새로운 객체가 만들어진다
    // 이렇게 직접 init하고 destroy를 설정해준다. 수동으로 가져온 클래스안에는 시작과 끝을 위한 메서드는 반드시 존재한다.
    @Bean(initMethod = "init", destroyMethod = "destroy")
    public BoardService2 boardService2() {
        return new BoardService2();
    }
}



