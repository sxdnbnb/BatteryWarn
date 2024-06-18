package com.example.micar;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.example.micar.mapper")
@SpringBootApplication
public class MiCarApplication {

    public static void main(String[] args) {
        SpringApplication.run(MiCarApplication.class, args);
    }

}
