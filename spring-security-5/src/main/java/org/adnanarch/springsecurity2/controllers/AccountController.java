package org.adnanarch.springsecurity2.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

    @GetMapping(path = "/myAccount")
    public String getAccountDetails(){
        return "Here are the Account Details from DB";
    }
}
