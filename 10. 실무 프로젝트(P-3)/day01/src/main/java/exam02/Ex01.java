package exam02;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.time.LocalDateTime;

public class Ex01 {
    public static void main(String[] args) throws Exception{
        Class clazz = Member.class;

        Constructor constructor = clazz.getDeclaredConstructors()[0];
        // 만약에 첫번째 생성자가 디폴트 생성자가 아니면 보고 설정해야하는건가?
        Object obj = constructor.newInstance();

        Method[] methods = clazz.getDeclaredMethods();
        for(Method method : methods) {
            String name = method.getName();
            if(!name.startsWith("set")){
                continue;
            }

            Class clz = method.getParameterTypes()[0];
            Object arg = 0;
            if(clz == String.class){ // setter 메서드의 매개변수가 문자열
                arg = "문자열";
            } else if(clz == LocalDateTime.class){ // setter 메서드의 매개변수가 LocalDateTime
                arg = LocalDateTime.now();
            }

            method.invoke(obj, arg); // setter 메서드 호출
        }

        System.out.println(obj);
    }
}
