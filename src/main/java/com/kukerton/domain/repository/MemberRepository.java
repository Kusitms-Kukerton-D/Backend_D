package com.kukerton.domain.repository;

import com.kukerton.domain.entity.Member;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {

    Optional<Member> findByAuthId(Long authId);

}
