package com.example.PhotoMap.repository;

import com.example.PhotoMap.domain.entity.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);
    Optional<Member> findById(String id);
    void updateInfo(Member member);
    void singOut(String id);
}
