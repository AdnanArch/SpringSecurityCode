package org.adnanarch.springsecurity2.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CardsController {
    @GetMapping(path = "/myCards")
    public String getCards(){
        return "Here are the cards from DB";
    }
}
