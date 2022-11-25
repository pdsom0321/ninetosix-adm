package com.gsc.ninetosixadm.ninetosix.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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

    @GetMapping(value="/admin/detail/{id}")
    public ModelAndView detail(@PathVariable Long id) {
        ModelAndView mv = new ModelAndView();
        mv.addObject("id", id);
        mv.setViewName("/detail");
        return mv;
    }

    @GetMapping(value="/admin/update/{id}")
    public ModelAndView modify(@PathVariable Long id) {
        ModelAndView mv = new ModelAndView();
        mv.addObject("id", id);
        mv.setViewName("/update");
        return mv;
    }
}
