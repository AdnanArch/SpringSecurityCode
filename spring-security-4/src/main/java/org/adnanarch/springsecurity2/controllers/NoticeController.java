package org.adnanarch.springsecurity2.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NoticeController {
    @GetMapping(path = "/notice")
    public String getNotice(){
        return "Here are the notices from DB";
    }
}
