package com.kukerton.domain.repository;

import com.kukerton.domain.entity.Certification;
import com.kukerton.domain.entity.Member;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MemberRepository extends JpaRepository<Member, Long> {

    Optional<Member> findByAuthId(Long authId);

    @Query("select c from Certification c where c.member.id = :memberId and c.is_cleared = false")
    List<Certification> getUnClearedCertification(@Param("memberId") Long memberId);


}
