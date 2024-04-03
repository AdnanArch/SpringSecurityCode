package org.adnanarch.springsecurity2.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BalanceController {
    @GetMapping(path = "/myBalance")
    public String getBalance(){
        return "Here is the balance from DB";
    }
}
