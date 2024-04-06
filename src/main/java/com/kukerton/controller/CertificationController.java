package com.kukerton.controller;

import com.kukerton.dto.request.CertificationRequestDto;
import com.kukerton.global.enums.GlobalSuccessCode;
import com.kukerton.global.response.BfResponse;
import com.kukerton.service.CertificationService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @PostMapping()
    public ResponseEntity<BfResponse<?>> createCertification(
        @Valid @RequestBody CertificationRequestDto dto){
        log.info("controller 실행~~!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        return ResponseEntity.status(HttpStatus.CREATED)
            .body(new BfResponse<>(GlobalSuccessCode.CREATE,certificationService.createCertification(dto)));
    }

}
