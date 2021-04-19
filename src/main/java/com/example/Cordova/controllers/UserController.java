package com.example.Cordova.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class UserController {

    @GetMapping("/")
    public String RenderHomePage(Principal principal, Model m){
        m.addAttribute("user", principal);
        return "home";
    }

    @GetMapping("/gallery")
    public String RenderGallery(Principal principal, Model m){
        m.addAttribute("computers", principal);
        return "gallery";
    }

    @GetMapping("/contact")
    public String RenderContact(Principal principal, Model m){
        return "contact";
    }

    @GetMapping("/aboutme")
    public String RenderAboutme(Principal principal, Model m){
        return "aboutme";
    }
}
