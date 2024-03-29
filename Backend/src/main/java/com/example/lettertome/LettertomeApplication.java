package com.example.lettertome;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jca.endpoint.GenericMessageEndpointFactory;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@SpringBootApplication
public class LettertomeApplication {

    public static void main(String[] args) {
        SpringApplication.run(LettertomeApplication.class, args);
    }

//    @Bean
//    public InternalResourceViewResolver setupViewResolver(){
//        InternalResourceViewResolver internalResourceViewResolver
//                = new InternalResourceViewResolver();
//        internalResourceViewResolver.setPrefix("/WEB-INF/views/");
//        internalResourceViewResolver.setSuffix(".html");
//        return internalResourceViewResolver;
//    }

}
