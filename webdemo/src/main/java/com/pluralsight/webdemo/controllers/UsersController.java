package com.pluralsight.webdemo.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsersController {

    @RequestMapping(path="/users", method= RequestMethod.GET)
    public String index(){
        return "users page";
    }
}
