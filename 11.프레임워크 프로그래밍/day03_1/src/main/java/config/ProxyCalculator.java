package config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class ProxyCalculator {

    @Pointcut("execution(* exam01..*(..))") // exam01쪽 모든 메서드를 호출해준다.
    public void publicTarget() {}

    @Around("publicTarget()") //
    public Object process(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("유입!");

        Object result = joinPoint.proceed(); // 핵심 기능 디신 실행 - factorial

        return result;
    }
}
