package com.example.PhotoMap.config.auth;

import com.example.PhotoMap.domain.entity.Member;
import com.example.PhotoMap.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PrincipalDetailsService implements UserDetailsService {

    @Autowired
    private MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {
        Optional<Member> member = memberRepository.findById(id);
        if (member.isPresent()){
            return new PrincipalDetails(member.get());
        }
        throw new UsernameNotFoundException("UsernameNotFoundException");
    }
}
