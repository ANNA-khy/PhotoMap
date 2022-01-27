package com.example.PhotoMap.repository;

import com.example.PhotoMap.domain.entity.Member;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.Optional;

@Repository
public class MySQLMemberRepository implements MemberRepository{

    private final EntityManager em;

    public MySQLMemberRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public Member save(Member member) {
        em.persist(member);
        return member;
    }

    @Override
    public Optional<Member> findById(String id) {
        Member member = em.find(Member.class, id);
        return Optional.ofNullable(member);
    }

    @Override
    public void updateInfo(Member member) {
    }

    @Override
    public void singOut(String id) {
        Optional<Member> member = findById(id);
        em.remove(member);
    }
}
