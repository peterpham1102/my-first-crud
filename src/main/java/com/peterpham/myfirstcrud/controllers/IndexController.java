package com.peterpham.myfirstcrud.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @RequestMapping({"", "/", "/index"})
    public String sayHello() {
        System.out.println("HELLO");
        return "index";
    }

    @RequestMapping("/login")
    public String Login() {

        System.out.println("WTF");
        return "login/login";
    }
}
