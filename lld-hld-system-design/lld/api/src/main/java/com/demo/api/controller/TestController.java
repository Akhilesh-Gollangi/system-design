package com.demo.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    // exposing some parts of code through fuctions via links (which is endpoint) is known as API
    // API is interface between 2 servies to communicate

    // without anotation it is normal function

    @GetMapping("/test")
    public String test() {
        return "Hello World";
    }
}
