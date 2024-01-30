package com.sb.sampleapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.sb"})
public class RestApi1Application {

    public static void main(String[] args) {
        SpringApplication.run(RestApi1Application.class, args);
    }

}
