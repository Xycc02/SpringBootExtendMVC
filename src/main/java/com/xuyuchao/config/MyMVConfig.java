package com.xuyuchao.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Locale;

/**
 * @Author: xuyuchao
 * @Date: 2022-05-18-8:50
 * @Description:
 */
//如果想diy一些定制化的功能,只需要写这个组件,然后将它交给SpringBoot,他就会帮我们自动装配
//扩展springmvc,添加@Configuration注解并实现WebMvcConfigurer接口,可以重写很多方法实现扩展SpringMVC
@Configuration
// @EnableWebMvc
public class MyMVConfig implements WebMvcConfigurer {


    @Bean
    public ViewResolver getMyViewResolver() {
        return new MyViewResolver();
    }

    //实现了视图解析器接口(ViewResolver)的类我们就可以把它看作视图解析器
    public static class MyViewResolver implements ViewResolver {
        //重写其中一个方法
        @Override
        public View resolveViewName(String viewName, Locale locale) throws Exception {
            return null;
        }
    }


    //视图跳转

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/hello").setViewName("/hello");
    }
}
