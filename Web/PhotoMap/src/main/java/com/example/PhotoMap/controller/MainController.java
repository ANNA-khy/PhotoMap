package com.example.PhotoMap.controller;

import com.example.PhotoMap.domain.entity.Member;
import com.example.PhotoMap.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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
    @GetMapping("/nomembers")
    public String nomemberMenu(Model model){
        return "";
    }
    @GetMapping("/members")
    public String memberMenu(Model model){
        return "members";
    }
    @GetMapping("/members/singup")
    public String createForm(Model model){
        return "singup";
    }

    @PostMapping("/members/singup")
    public String register(MemberForm form){
        Member member = new Member();
        member.setId(form.getId());
        member.setPassword(form.getPassword());
        member.setEmail(form.getEmail());

        this.memberService.join(member);

        return "/login";
    }

    @GetMapping("/login")
    public String login(Model model){
        Member member = new Member();
        return "login";
    }
}
