package com.breedmanager.data;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebAppConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/user").setViewName("userPanel");
        registry.addViewController("/403").setViewName("403");
        registry.addViewController("/logout").setViewName("logout");
        registry.addViewController("/doggo").setViewName("doggo");
    }
}