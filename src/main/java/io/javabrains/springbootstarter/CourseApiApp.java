package io.javabrains.springbootstarter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
Sets up default configuration
Starts Apring Application Context
Performs class path scan
Starts Tomcat Server
 */
@SpringBootApplication
public class CourseApiApp {
    public static void main(String[] args) {
        SpringApplication.run(CourseApiApp.class,args);

    }
}
