package com.petcare;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration 
@SpringBootApplication
public class Application extends SpringBootServletInitializer {

    public static void main(String[] args){
        SpringApplicationBuilder springApplicationBuilder = new SpringApplicationBuilder(Application.class);

        SpringApplication springApplication = springApplicationBuilder.build();
        springApplication.run(args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(Application.class);
    }
}