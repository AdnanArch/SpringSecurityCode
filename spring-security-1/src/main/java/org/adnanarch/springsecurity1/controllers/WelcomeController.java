package org.adnanarch.springsecurity1.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

    @GetMapping(path = "/welcome")
    public String welcome(){
        return "Hello Welcome to Spring Security";
    }

}
