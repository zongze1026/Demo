package com.huatong.config;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Create By xzz on 2018/11/19
 */
@Configuration
public class WebAppConfig implements WebMvcConfigurer {


    /**
     * 跨域解决方案
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**").allowedMethods("GET", "POST");
    }



}
