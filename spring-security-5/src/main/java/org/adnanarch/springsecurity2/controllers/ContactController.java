package org.adnanarch.springsecurity2.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContactController {
     @GetMapping(path = "/contact")
     public String getContact(){
         return "Here are the contacts from DB";
     }
}
