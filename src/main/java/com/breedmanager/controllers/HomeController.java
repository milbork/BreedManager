package com.breedmanager.controllers;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String start(){
        return "index";
    }


    @RequestMapping("/doggo")
    public String doggo(){
        return "doggo";
    }
}
