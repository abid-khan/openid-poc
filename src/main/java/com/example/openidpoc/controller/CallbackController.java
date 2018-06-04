package com.example.openidpoc.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CallbackController {

    @RequestMapping("/callback")
    @GetMapping
    public void callback(){
        System.out.print("Name : " + SecurityContextHolder.getContext().getAuthentication().getName());
    }

    @RequestMapping("/login")
    @GetMapping
    public void login(HttpServletResponse response) throws IOException {
        response.sendRedirect("/");
    }
}
