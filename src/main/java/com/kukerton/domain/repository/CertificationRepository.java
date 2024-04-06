package com.kukerton.domain.repository;

import com.kukerton.domain.entity.Certification;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CertificationRepository extends JpaRepository<Certification, Long> {

    List<Certification> findAllByMemberId(Long memberId);
}
