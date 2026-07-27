package com.cognizant.employeemanagementsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.cognizant")
@EnableJpaRepositories(basePackages = "com.cognizant.repository")
@EntityScan(basePackages = "com.cognizant.model")
public class EmployeeManagementSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(
                EmployeeManagementSystemApplication.class,
                args
        );
    }
}