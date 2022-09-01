package com.lisijing.paramfilter.controller;

import com.lisijing.paramfilter.annotations.RequestDecrypt;
import com.lisijing.paramfilter.annotations.ResponseEncrypt;
import com.lisijing.paramfilter.entity.PersonVO;
import org.springframework.web.bind.annotation.*;

@RestController
public class TestController {

    @GetMapping("/get")
    @RequestDecrypt
    @ResponseEncrypt
    public String getMethod(@RequestParam String name){
        return "hello :" + name;
    }

    @PostMapping("/post")
    @RequestDecrypt
    @ResponseEncrypt
    public String postMethod(@RequestBody PersonVO person){
        return "hello :" + person.getName();
    }


}
