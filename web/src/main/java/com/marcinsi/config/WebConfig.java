package com.marcinsi.config;

import com.marcinsi.interceptor.RequestInterceptor;
import com.marcinsi.util.ViewNames;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {

        registry.addViewController("/").setViewName(ViewNames.HOME);
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        // We add an interceptor created by us

        registry.addInterceptor(new RequestInterceptor());
    }
}
