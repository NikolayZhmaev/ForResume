package net.thumbtack.school.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class MainApplication {


    public static void main(String[] args) {
        System.out.println("Start application");
        SpringApplication.run(MainApplication.class);
        System.out.println("Stop application");
    }
}
