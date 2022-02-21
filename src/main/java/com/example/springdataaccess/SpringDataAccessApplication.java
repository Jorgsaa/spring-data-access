package com.example.springdataaccess;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.List;

@SpringBootApplication
@EnableWebMvc
public class SpringDataAccessApplication {

    // TEMPORARY, ONLY FOR TESTING
    @RestController
    @RequestMapping("/api")
    public class ExampleRestController {

        private final JdbcTemplate jdbcTemplate;

        public ExampleRestController(JdbcTemplate jdbcTemplate) {
            this.jdbcTemplate = jdbcTemplate;
        }

        @GetMapping
        public String hello()
        {
            return "Hello from API";
        }

        @GetMapping("/albums")
        public List<String> albums() {
            List<String> albums = jdbcTemplate.query("SELECT * FROM Album",
                    (resultSet, rowNum) -> resultSet.getString("Title")
            );
            return albums;
        }

    }

    // TEMPORARY, ONLY FOR TESTING
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
