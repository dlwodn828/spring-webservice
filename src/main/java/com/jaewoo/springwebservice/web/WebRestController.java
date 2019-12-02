package com.jaewoo.springwebservice.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebRestController {
    @GetMapping("/hello")
    public String hello(){
        return "HelloWorld"; // String을 json형태로 반환
    }
}
