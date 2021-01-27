package com.example.k8s.demo.controller;


import com.example.k8s.demo.DemoApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class TestController {

    private static final Logger LOGGER = LoggerFactory.getLogger(DemoApplication.class);

    @GetMapping("/test")
    public String test() {

        for (int i = 0; i < 10; i++) {
            LOGGER.info("========================={},{}", "EKS Gitops Test", new Date());
        }

        String first = first();second();

        return "This is the gitops test v 9.0.0" + first;

    }

    public String first() {
        String second = second();
        LOGGER.info("========================={},{}", "EKS Gitops Test", new Date());
        return second;
    }

    public String second() {
        LOGGER.info("========================={},{}", "EKS Gitops Test", new Date());
        return "123";
    }


}
