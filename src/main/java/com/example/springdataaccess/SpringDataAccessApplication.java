package com.example.springdataaccess;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
public class SpringDataAccessApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringDataAccessApplication.class, args);
    }

}
