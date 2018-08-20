package com.snail2lb.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource(locations = "classpath*:hodorset-web.xml")
public class HodorsetApplication {

    public static void main(String[] args) {
        SpringApplication.run(HodorsetApplication.class, args);
    }
}
