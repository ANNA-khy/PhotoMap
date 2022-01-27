package com.example.PhotoMap.config;

import com.example.PhotoMap.repository.MemberRepository;
import com.example.PhotoMap.repository.MySQLMemberRepository;
import com.example.PhotoMap.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

@Configuration
public class RepoConfig {
    private final DataSource dataSource;
    private final EntityManager em;

    public RepoConfig(DataSource dataSource, EntityManager em) {
        this.dataSource = dataSource;
        this.em = em;
    }

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository(), passwordEncoder());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MySQLMemberRepository(em);
    }


    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

}
