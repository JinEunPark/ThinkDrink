package com.datacampus.biohealth2.repository;

import com.datacampus.biohealth2.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member,Long> {
    public Member findByEmail(String email);
    Member findByName(String username);
}
