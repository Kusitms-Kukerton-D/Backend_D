package com.kukerton.service;

import com.kukerton.domain.entity.Certification;
import com.kukerton.domain.repository.CertificationRepository;
import com.kukerton.domain.repository.MemberRepository;
import com.kukerton.dto.request.CertificationRequestDto;
import com.kukerton.dto.response.CertificationResponseDto;
import com.kukerton.dto.response.UnClearCertificationResponseDto;
import com.kukerton.global.enums.CertificationErrorCode;
import com.kukerton.global.exception.CertificationException;
import java.util.ArrayList;
import java.util.List;
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

    @Transactional(readOnly = true)
    public List<UnClearCertificationResponseDto> getUnclearCertification(Long memberId) {

        List<UnClearCertificationResponseDto> response = new ArrayList<>();
        List<String> images = List.of(
            "https://kukerton.s3.ap-northeast-2.amazonaws.com/4f43e07f-a3a4-49eb-b5c4-857cf08c7962.png",
            "https://kukerton.s3.ap-northeast-2.amazonaws.com/7a34e1e1-882b-45cf-8b40-01d0e54912f3.png",
            "https://kukerton.s3.ap-northeast-2.amazonaws.com/c9eddaa7-dba8-4901-89af-c8842fa42b17.png");
        List<Certification> unClearedCertifications = memberRepository.getUnClearedCertification(
            memberId);

        if (!unClearedCertifications.isEmpty()) {

//            unClearedCertifications.forEach(certification -> {
//                response.add(UnClearCertificationResponseDto.builder()
//                    .taskTitle(certification.getContent())
//                    .content(certification.getTaskTitle())
//                    .certificationId(certification.getId())
//                    .build());
//            });

            for (int i = 0; i < unClearedCertifications.size(); i++) {
                Certification certification = unClearedCertifications.get(i);
                response.add(UnClearCertificationResponseDto.builder()
                    .taskTitle(certification.getContent())
                    .content(certification.getTaskTitle())
                    .certificationId(certification.getId())
                    .imageUrl(images.get(i))
                    .build());
            }
        }

        return response;
    }

    @Transactional(readOnly = true)
    public CertificationResponseDto getCertification(Long certificationId) {

        Certification certification = certificationRepository.findById(certificationId)
            .orElseThrow(() -> new CertificationException(CertificationErrorCode.NOT_FOUND));

        return CertificationResponseDto.fromEntity(certification);
    }

}
