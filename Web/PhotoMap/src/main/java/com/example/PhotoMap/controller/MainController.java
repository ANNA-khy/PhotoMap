package com.example.PhotoMap.controller;

import com.example.PhotoMap.domain.entity.Member;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @GetMapping("/")
    public String home(){
        return "home";
    }
    @GetMapping("/nomembers")
    public String nomemberMenu(Model model){
        return "";
    }
    @GetMapping("/members")
    public String memberMenu(Model model){
        return "members";
    }
    @GetMapping("/members/singup")
    public String register(Model model){
        Member member = new Member();
        return "singup";
    }
    @GetMapping("/login")
    public String login(Model model){
        Member member = new Member();
        return "redirect:/";
    }
}
