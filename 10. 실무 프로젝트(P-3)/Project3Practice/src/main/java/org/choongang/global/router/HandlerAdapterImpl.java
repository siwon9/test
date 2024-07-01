package org.choongang.global.router;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.choongang.global.config.annotations.*;

import java.io.PrintWriter;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HandlerAdapterImpl implements HandlerAdapter{

    private final ObjectMapper om;

    public HandlerAdapterImpl() {
        om = new ObjectMapper();
        om.registerModule(new JavaTimeModule());
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response, List<Object> data) {
        Object controller = data.get(0);
        Method method = (Method)data.get(1);

        String m = request.getMethod().toUpperCase();
        Annotation[] annotations = method.getDeclaredAnnotations();

        String[] rootUrls = {""};
        for(Annotation anno : controller.getClass().getDeclaredAnnotations()) {
            rootUrls = getMappingUrl(m, anno);
        }

        String[] pathUrls = {""};
        Map<String, String> pathVariables = new HashMap<>();
        for(Annotation anno : annotations) {
            pathUrls = getMappingUrl(m, anno);
        }

        if(pathUrls != null) {
            Pattern p = Pattern.compile("\\{(\\w+)\\}");
            for(String url : pathUrls) {
                Matcher matcher = p.matcher(url);

                List<String> matched = new ArrayList<>();
                while(matcher.find()) {
                    matched.add(matcher.group(1));
                }
                if(matched.isEmpty()) continue;

                for(String rUrl : rootUrls) {
                    String _url = request.getContextPath() + rUrl + url;
                    for(String s : matched) {
                        _url = _url.replace("{" + s + "}", "(\\w*)");
                    }

                    Pattern p2 = Pattern.compile("^" + _url+"$");
                    Matcher matcher2 = p2.matcher(request.getRequestURI());
                    while (matcher2.find()) {
                        for (int i=0; i< matched.size(); i++) {
                            pathVariables.put(matched.get(i), matcher2.group(i + 1));
                        }
                    }
                }
            }
        }

        List<Object> args = new ArrayList<>();
        for(Parameter param : method.getParameters()) {
            try {
                Class cls = param.getType();
                String paramValue = null;
                for(Annotation pa : param.getDeclaredAnnotations()) {
                    if (pa instanceof RequestParam requestParam) {
                        String paramName = requestParam.value();
                        paramValue = request.getParameter(paramName);
                        break;
                    } else if (pa instanceof PathVariable pathVariable) {
                        String pathName = pathVariable.value();
                        paramValue = pathVariables.get(pathName);
                        break;
                    }
                }
                if(cls == int.class || cls == Integer.class || cls == long.class || cls == Long.class
                        || cls == double.class || cls ==Double.class || cls ==float.class || cls == Float.class){
                    paramValue = paramValue == null || paramValue.isBlank()?"0" : paramValue;
                }
                if(cls == HttpServletRequest.class){
                    args.add(request);
                } else if (cls == HttpServletResponse.class) {
                    args.add(response);
                } else if (cls == int.class) {
                    args.add(Integer.parseInt(paramValue));
                } else if (cls == Integer.class){
                    args.add(Integer.valueOf(paramValue));
                } else if (cls == long.class) {
                    args.add(Long.parseLong(paramValue));
                } else if (cls == Long.class) {
                    args.add(Long.valueOf(paramValue));
                } else if (cls == float.class) {
                    args.add(Float.parseFloat(paramValue));
                } else if (cls == Float.class) {
                    args.add(Float.valueOf(paramValue));
                } else if (cls == double.class){
                    args.add(Double.parseDouble(paramValue));
                } else if (cls == Double.class) {
                    args.add(Double.valueOf(paramValue));
                } else if (cls == String.class) {
                    args.add(paramValue);
                } else {
                    Object paramObj = cls.getDeclaredConstructors()[0].newInstance();
                    for (Method _method : cls.getDeclaredConstructors()) {
                        String name = _method.getName();
                        if(!name.startsWith("set")) continue;

                        char[] chars = name.replace("set", "").toCharArray();
                        chars[0] = Character.toLowerCase(chars[0]);
                        name = String.valueOf(chars);
                        String value = request.getParameter(name);
                        if (value == null) continue;

                        Class clz = _method.getParameterTypes()[0];
                        invokeMethod(paramObj,_method, value, clz, name);
                    }
                    args.add(paramObj);
                }
            } catch(Exception e) {
                throw new RuntimeException(e.getMessage());
            }
        }

        try {
            Object result = args.isEmpty() ? method.invoke(controller) : method.invoke(controller, args.toArray());
            boolean isRest = Arrays.stream(controller.getClass().getDeclaredAnnotations()).
                    anyMatch(a -> a instanceof RestController);

            if(isRest) {
                response.setContentType("application/json; charset=UTF-8");
                String json = om.writeValueAsString(result);
                PrintWriter out = response.getWriter();
                out.print(json);
                return;
            }

            String tpl = "/WEB-INF/templates/" + result + ".jsp";
            RequestDispatcher rd = request.getRequestDispatcher(tpl);
            rd.forward(request, response);

        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    private void invokeMethod(Object paramObj, Method method, String value, Class clz, String fieldNm) {
        try {
            if(clz == String.class){
                method.invoke(paramObj, value);

            } else if (clz == boolean.class) {
                method.invoke(paramObj, Boolean.parseBoolean(value));
            } else if (clz == Boolean.class) {
                method.invoke(paramObj, Boolean.valueOf(value));
            } else if (clz == byte.class) {
                method.invoke(paramObj, Byte.parseByte(value));
            } else if (clz == Byte.class) {
                method.invoke(paramObj, Byte.valueOf(value));
            } else if (clz == short.class) {
                method.invoke(paramObj, Short.parseShort(value));
            } else if (clz == Short.class) {
                method.invoke(paramObj, Short.valueOf(value));
            } else if (clz == int.class) {
                method.invoke(paramObj, Integer.parseInt(value));
            } else if (clz == Integer.class) {
                method.invoke(paramObj, Integer.valueOf(value));
            } else if (clz == long.class) {
                method.invoke(paramObj, Long.parseLong(value));
            } else if (clz == Long.class) {
                method.invoke(paramObj, Long.valueOf(value));
            } else if (clz == float.class) {
                method.invoke(paramObj, Float.parseFloat(value));
            } else if (clz == Float.class) {
                method.invoke(paramObj, Float.valueOf(value));
            } else if (clz == double.class) {
                method.invoke(paramObj, Double.parseDouble(value));
            } else if (clz == Double.class) {
                method.invoke(paramObj, Double.valueOf(value));
            } else if (clz == LocalDateTime.class || clz == LocalDate.class || clz == LocalTime.class) {
                Field field = paramObj.getClass().getDeclaredField(fieldNm);
                for (Annotation a : field.getDeclaredAnnotations()) {
                    if(a instanceof DateTimeFormat dateTimeFormat) {
                        String pattern = dateTimeFormat.value();
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
                        if (clz == LocalTime.class) {
                            method.invoke(paramObj, LocalTime.parse(value, formatter));
                        } else if (clz == LocalDate.class) {
                            method.invoke(paramObj, LocalDate.parse(value, formatter));
                        } else {
                            method.invoke(paramObj, LocalDateTime.parse(value, formatter));
                        }
                        break;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //mapping된 url 패턴을 문자열 배열로 반환하는 기능이다.
    private String[] getMappingUrl(String method, Annotation anno) {

        if(anno instanceof RequestMapping) {
            RequestMapping mapping = (RequestMapping) anno;
            return mapping.value(); // 문자열 배열 반환
        }
        if(method.equals("GET")&& anno instanceof GetMapping) {
            GetMapping mapping = (GetMapping) anno;
            return mapping.value();
        } else if (method.equals("POST") && anno instanceof PostMapping) {
            PostMapping mapping = (PostMapping) anno;
            return mapping.value();
        } else if (method.equals("PATCh") && anno instanceof PatchMapping) {
            PatchMapping mapping = (PatchMapping) anno;
            return mapping.value();
        } else if (method.equals("PUT") && anno instanceof PutMapping) {
            PutMapping mapping = (PutMapping) anno;
            return mapping.value();
        } else if (method.equals("DELETE") && anno instanceof  DeleteMapping) {
            DeleteMapping mapping = (DeleteMapping) anno;
            return mapping.value();
        }
        return null;
    }
}















