package org.adnanarch.springsecurity2.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoansController {
    @GetMapping(path = "/myLoans")
    public String getLoans(){
        return "Here are the loans from DB";
    }
}
