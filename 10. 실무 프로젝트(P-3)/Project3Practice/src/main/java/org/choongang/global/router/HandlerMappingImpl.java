package org.choongang.global.router;

import jakarta.servlet.http.HttpServletRequest;
import org.choongang.global.config.annotations.*;
import org.choongang.global.config.containers.BeanContainer;

import javax.sound.midi.Patch;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class HandlerMappingImpl implements HandlerMapping{

    private String controllerUrl;

    @Override
    public List<Object> search(HttpServletRequest request) {
        List<Object> items = getControllers();

        for(Object item : items) {
            if(isMatch(request, item.getClass().getDeclaredAnnotations(), false,null)){
                for(Method m : item.getClass().getDeclaredMethods()) {
                    if (isMatch(request, m.getDeclaredAnnotations(), true, controllerUrl)) {
                        return List.of(item, m);
                    }
                }
            }
            for(Method m : item.getClass().getDeclaredMethods()) {
                if(isMatch(request, m.getDeclaredAnnotations(), true, null)) {
                    return List.of(item, m);
                }
            }
        }
        return null;
    }

    private boolean isMatch(HttpServletRequest request, Annotation[] annotations, boolean isMethod, String prefixUrl){

        String uri = request.getRequestURI();
        String method = request.getMethod().toUpperCase();
        String[] mappings = null;

        for(Annotation anno : annotations) {

            if(anno instanceof RequestMapping) {
                RequestMapping mapping = (RequestMapping) anno;
                mappings = mapping.value();
            } else if (anno instanceof GetMapping && method.equals("GET")) {
                GetMapping mapping = (GetMapping) anno;
                mappings = mapping.value();
            } else if (anno instanceof PostMapping && method.equals("POST")) {
                PostMapping mapping = (PostMapping) anno;
                mappings = mapping.value();
            } else if ( anno instanceof  PutMapping && method.equals("PUT")) {
                PutMapping mapping = (PutMapping) anno;
                mappings = mapping.value();
            } else if ( anno instanceof  PatchMapping && method.equals("PATCH")) {
                PatchMapping mapping = (PatchMapping) anno;
                mappings = mapping.value();
            } else if (anno instanceof DeleteMapping && method.equals("DELETE")) {
                DeleteMapping mapping = (DeleteMapping) anno;
                mappings = mapping.value();
            }

            if(mappings != null && mappings.length>0) {
                String matchUrl = null;
                if(isMethod) {
                    String addUrl = prefixUrl==null ? "" : prefixUrl;
                    for(String mapping : mappings) {
                        String pattern = mapping.replace("/*", "/\\w*")
                                .replaceAll("/\\{\\w+\\}", "/(\\\\w*)");
                        Pattern p = Pattern.compile("^" + request.getContextPath() + addUrl + pattern + "$");
                        Matcher matcher = p.matcher(uri);
                        return matcher.find();
                    }
                } else {
                    List<String> matches = Arrays.stream(mappings)
                            .filter(s -> uri.startsWith(request.getContextPath() + s)).toList();
                        // uri가 request 컨텍스트 경로 + s 문자열로 시작하는지 걸러준다,
                    if(!matches.isEmpty()) {
                        matchUrl = matches.get(0); //비어있지 않으면, matches 첫번째 값 대입
                        controllerUrl=matchUrl; // 대입
                    }
                }
                return matchUrl != null && !matchUrl.isBlank();
            }
        }
        return false;
    }

    private List<Object> getControllers() {
        return BeanContainer.getInstance().getBeans().entrySet()
                // BeanContainer 인스턴스가져오고, Map형태의 beans가져와서 entrySet으로 변경
                .stream().map(s -> s.getValue()) // 각 요소마다 값 반환
                .filter(b -> Arrays.stream(b.getClass().getDeclaredAnnotations())
                        //각 요소의 클래스를 가져오고, 해당 요소에서 선언된 애너테이션들을 가져온다.
                        .anyMatch(a -> a instanceof Controller || a instanceof RestController))
                        //위 둘 중 하나라도 있는지 확인하고 있는것만 걸러서
                        .toList(); // 리스트를 만든다
    }
}
