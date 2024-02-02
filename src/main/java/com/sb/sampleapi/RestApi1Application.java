package com.sb.sampleapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;


@SpringBootApplication
@ComponentScan(basePackages = {"com.sb.sampleapi.controller", "com.sb.sampleapi.service", "com.sb.sampleapi.repository"})
@EntityScan(basePackages = {"com.sb.sampleapi.domain"})
public class RestApi1Application {

    public static void main(String[] args) {
        SpringApplication.run(RestApi1Application.class, args);
    }


}
