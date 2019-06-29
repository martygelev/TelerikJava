package com.team6.beertagweb.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/start")
public class HomeController {
    @GetMapping
    public String showHomePage(){
        return "start";
    }

    @GetMapping("/allbeers")
    public String showBeersPage(){
        return "allBeers";
    }
}
