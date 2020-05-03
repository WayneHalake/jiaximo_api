package com.jiaximo.jiaximo_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class JiaximoApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(JiaximoApiApplication.class, args);
    }

}
