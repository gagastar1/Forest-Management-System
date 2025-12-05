package com.forest.management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ForestManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(ForestManagementApplication.class, args);
        System.out.println("========================================");
        System.out.println("Forest Management System API is running!");
        System.out.println("Server: http://localhost:8080");
        System.out.println("========================================");
    }
}
