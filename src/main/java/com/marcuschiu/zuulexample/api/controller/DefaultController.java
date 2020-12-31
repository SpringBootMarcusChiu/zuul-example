package com.marcuschiu.zuulexample.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/default")
public class DefaultController {

    @GetMapping("/test")
    public String get() {
        return "Hello, World!";
    }

    @GetMapping("/header")
    public String header(HttpServletRequest req, HttpServletResponse res) {
        if (req.getHeader("Test") != null) {
            res.addHeader("Test", req.getHeader("Test"));
        }
        return "Hello, World!";
    }
}
