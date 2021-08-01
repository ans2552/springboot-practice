package com.ans2552.practice.springboot.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello2(){
        return "hello";
    }

    @GetMapping("/hello2")
    public String hello(@RequestParam String id, @RequestParam (name = "password") String pwd){
        return "hello2";
    }
}
