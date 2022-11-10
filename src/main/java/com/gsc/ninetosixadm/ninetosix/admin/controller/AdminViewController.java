package com.gsc.ninetosixadm.ninetosix.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminViewController {

    @RequestMapping(value="/login")
    public String login() {
        return "login";
    }

    @RequestMapping(value="/admin")
    public String main() {
        return "admin";
    }
}
