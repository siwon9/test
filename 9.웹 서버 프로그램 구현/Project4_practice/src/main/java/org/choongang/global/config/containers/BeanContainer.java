package org.choongang.global.config.containers;

import org.choongang.global.config.annotations.RestController;

import java.io.File;
import java.lang.annotation.Annotation;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BeanContainer {
    private static BeanContainer instance;

    private Map<String, Object> beans;

    public BeanContainer() {
        beans = new HashMap<>();
    }

    public void loadBeans() {
        // 패키지 경로 기준으로 스캔 파일 경로 조회
        try{
            String rootPath = new File(getClass().getResource("../../../").getPath())
                .getCanonicalPath(
                String packageName =getClass().getPackageName().replace(".global.config.containers", "");
            List<Class> classNames = getClassNames(rootPath,packageName);

            for(Class clazz : classNames) {
                //인터페이스는 동적 객체 생성을 하지 않으므로 건너뛰기
                if(clazz.isInterface()) {
                    continue;
                }

                //애노테이션 중 Controller, RestController, Component, Service 등이 TYPE 애노테이션으로
                // 키 값은 전체 클래스명, 값은 생성된 객체
                String key = clazz.getName();

                //이미 생성된 객체라면 생성된 객체로 활용
                if(beans.containsKey(key)) continue;

                Annotation[] annotations = clazz.getDeclaredAnnotations();

                boolean isBean = false;
                for (Annotation anno : annotations) {
                    if(anno instanceof Controller || anno instanceof RestController
                            || anno instanceof isBean=true; break;)
                }

            }
        }
    }
}
