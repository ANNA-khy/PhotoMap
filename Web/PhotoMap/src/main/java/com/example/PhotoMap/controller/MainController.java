package com.example.PhotoMap.controller;

import com.example.PhotoMap.domain.entity.Member;
import com.example.PhotoMap.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
    private final MemberService memberService;

    /* dependency injection */
    @Autowired
    public MainController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/")
    public String home(){
        return "home";
    }

    @GetMapping("/fileUpload")
    public String fileUpload(Model model){
        return "fileUpload";
    }
    @GetMapping("/nomembers")
    public String nomemberMenu(Model model){
        return "";
    }
    @GetMapping("/members")
    public String memberMenu(Model model){
        return "members";
    }



}
