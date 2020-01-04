package com.cake;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.cake.repositories")
public class AppDriver {

    public static void main(String[] args) {
        SpringApplication.run(AppDriver.class, args);
    }
}
