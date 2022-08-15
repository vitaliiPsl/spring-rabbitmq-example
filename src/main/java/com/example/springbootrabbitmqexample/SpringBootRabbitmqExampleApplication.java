package com.example.springbootrabbitmqexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SpringBootRabbitmqExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootRabbitmqExampleApplication.class, args);
    }

}
