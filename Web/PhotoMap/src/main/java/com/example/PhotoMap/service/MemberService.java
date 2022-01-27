package com.example.PhotoMap.service;

import com.example.PhotoMap.domain.entity.Member;
import com.example.PhotoMap.repository.MemberRepository;
import net.bytebuddy.NamingStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional
public class MemberService {
    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public MemberService(MemberRepository memberRepository, PasswordEncoder passwordEncoder) {
        this.memberRepository = memberRepository;
        this.passwordEncoder = passwordEncoder;
    }

    /* 회원가입 */
    public String join(Member member){
        // 같은 이름이 있는 중복 회원 X
        validateDuplicateMember(member);
        String encodedPassword = passwordEncoder.encode(member.getPassword());
        member.setPassword(encodedPassword);
        memberRepository.save(member);
        return member.getId();
    }
    private void validateDuplicateMember(Member member) {
        memberRepository.findById(member.getId())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    /* 아이디 중복 확인 */
    public int idCheck(String id){
        Optional<Member> m = this.memberRepository.findById(id);

        if (m.isEmpty()){
            return 0;
        }

        else
            return 1;
    }
}
