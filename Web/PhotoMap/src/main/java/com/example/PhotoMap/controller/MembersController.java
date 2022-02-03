package com.example.PhotoMap.controller;

import com.example.PhotoMap.domain.entity.Member;
import com.example.PhotoMap.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/members")
public class MembersController {
    @Autowired
    private final MemberService memberService;
    @Autowired
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public MembersController(MemberService memberService, PasswordEncoder passwordEncoder) {
        this.memberService = memberService;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/signup")
    public String createForm(Model model){
        return "singup";
    }

    @PostMapping("/signup")
    public String register(MemberForm form){
        Member member = new Member();
        member.setId(form.getId());
        member.setPassword(passwordEncoder.encode(form.getPassword()));
        member.setEmail(form.getEmail());

        this.memberService.join(member);

        return "/login";
    }

    @GetMapping("/login")
    public String login(@RequestParam(value = "error", required = false) String error,
                        Model model){
        model.addAttribute("error", error);
        return "login";
    }

    @PostMapping("/signup/idCheck")
    @ResponseBody
    public int idCheck(@RequestParam("id") String id){
        int duplicate = memberService.idCheck(id);
        return duplicate;
    }
}
