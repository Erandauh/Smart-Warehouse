package com.my;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class SmartWarehouseApp {

    public static void main(String[] args) {
        SpringApplication.run(SmartWarehouseApp.class, args);
    }

}
