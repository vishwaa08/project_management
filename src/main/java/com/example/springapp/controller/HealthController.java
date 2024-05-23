package com.example.springapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {
	
    @GetMapping("/test/health")
    public String sayHello() {
//    	System.out.println("Hello world!");
    	return "Hello Paari";
    }
}
