package com.mallonline.taotao.portal.config;

import com.mallonline.taotao.portal.interceptor.LoginIterCeptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMVCInterceptorConfig implements WebMvcConfigurer {

    @Autowired
    private LoginIterCeptor loginIterCeptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(loginIterCeptor).addPathPatterns("/order/**");
    }


}
