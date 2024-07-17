package org.choongang.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class FileConfig implements WebMvcConfigurer {

    @Value("${file.upload.path}")
    private String uploadPath;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // 파일 업로드 정적 경로 설정

        registry.addResourceHandler("/uploads/**")
                .addResourceLocations("file:/" + uploadPath);
                // 윈도우는 /를 3개 넣어야 2개로 인식한다. 한개가 제거된다.
    }
}
