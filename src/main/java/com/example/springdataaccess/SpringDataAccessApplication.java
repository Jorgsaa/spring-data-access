package com.example.springdataaccess;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class SpringDataAccessApplication {

    @RestController
    @RequestMapping("/api")
    public class ExampleRestController {

        @GetMapping
        public String hello()
        {
            return "Hello from API";
        }

    }

    @Controller
    @RequestMapping("/")
    public class ExampleController {

        @GetMapping
        public String index() {
            return "index";
        }

    }

    public static void main(String[] args) {
        SpringApplication.run(SpringDataAccessApplication.class, args);
    }

}
