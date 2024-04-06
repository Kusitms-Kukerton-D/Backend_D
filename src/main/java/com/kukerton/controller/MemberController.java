package com.kukerton.controller;

import com.kukerton.dto.request.CertificationRequestDto;
import com.kukerton.global.enums.GlobalSuccessCode;
import com.kukerton.global.response.BfResponse;
import com.kukerton.service.MemberService;
import jakarta.validation.Valid;
import java.util.Map;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/member")
@RequiredArgsConstructor
@Tag(name = "로그인 API", description = "카카오 로그인 API")
public class MemberController {

    private final MemberService memberService;

    @Operation(summary = "카카오 로그인 API", description = "카카오 로그인을 위한 api 입니다.")
    @GetMapping("/login")
    public ResponseEntity<BfResponse<?>> login(@RequestParam(name = "code") String code) {
        return ResponseEntity.status(HttpStatus.OK)
            .body(new BfResponse<>(GlobalSuccessCode.LOGIN,
                Map.of("id", memberService.getUserInfoFromResourceServer(code))));
    }

    @Operation(summary = "쿠폰 목록 조회 API", description = "회원 프로필에서 쿠폰 목록 조회 api입니다.")
    @GetMapping("/{memberId}")
    public ResponseEntity<BfResponse<?>> getCoupon(@PathVariable("memberId") Long memberId) {
        return ResponseEntity.status(HttpStatus.OK)
            .body(new BfResponse<>(GlobalSuccessCode.SUCCESS,
                memberService.getCoupon(memberId)));
    }


}
