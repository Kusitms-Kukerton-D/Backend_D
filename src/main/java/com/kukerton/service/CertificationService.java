package com.kukerton.service;

import com.kukerton.domain.entity.Certification;
import com.kukerton.domain.repository.CertificationRepository;
import com.kukerton.domain.repository.MemberRepository;
import com.kukerton.dto.request.CertificationRequestDto;
import com.kukerton.dto.response.CertificationResponseDto;
import com.kukerton.global.enums.CertificationErrorCode;
import com.kukerton.global.exception.CertificationException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CertificationService {

    private final CertificationRepository certificationRepository;

    private final MemberRepository memberRepository;

    @Transactional
    public CertificationResponseDto createCertification(CertificationRequestDto dto) {

        Certification certification = certificationRepository.findById(dto.certificationId())
            .orElseThrow(() -> new CertificationException(CertificationErrorCode.NOT_FOUND));

        certification.certificate(dto); // 인증 내용을 기반으로 업데이트

        return CertificationResponseDto.fromEntity(certification);

    }

}
