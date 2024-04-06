package com.kukerton.controller;

import com.kukerton.dto.request.CertificationRequestDto;
import com.kukerton.global.enums.GlobalSuccessCode;
import com.kukerton.global.response.BfResponse;
import com.kukerton.service.CertificationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/certification")
@RequiredArgsConstructor
@Tag(name = "인증 API", description = "인증 게시글 API")
@Slf4j
public class CertificationController {

    private final CertificationService certificationService;

    @Operation(summary = "인증 글 생성 APII", description = "인증 글 생성을 위한 api 입니다.")
    @PostMapping()
    public ResponseEntity<BfResponse<?>> createCertification(
        @Valid @RequestBody CertificationRequestDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED)
            .body(new BfResponse<>(GlobalSuccessCode.CREATE,
                certificationService.createCertification(dto)));
    }

    @Operation(summary = "미완료 인증 조회 API", description = "미완료(완료하지 못한) 미션 목록 조회 api 입니다.")
    @GetMapping("/members/{memberId}")
    public ResponseEntity<BfResponse<?>> getCertificationList(
        @PathVariable("memberId") Long memberId) {
        return ResponseEntity.status(HttpStatus.OK)
            .body(new BfResponse<>(GlobalSuccessCode.SUCCESS,
                certificationService.getUnclearCertification(memberId)));
    }


    @Operation(summary = "인증글 상세 조회 API", description = "완료 인증글 상세 조회 api입니다.")
    @GetMapping("/{certificationId}")
    public ResponseEntity<BfResponse<?>> getCertification(
        @PathVariable("certificationId") Long certificationId) {
        return ResponseEntity.status(HttpStatus.OK)
            .body(new BfResponse<>(GlobalSuccessCode.SUCCESS,
                certificationService.getCertification(certificationId)));
    }


}
