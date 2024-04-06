package com.kukerton.controller;

import com.kukerton.global.enums.GlobalSuccessCode;
import com.kukerton.global.response.BfResponse;
import com.kukerton.service.MemberService;
import java.util.Map;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/login")
    public ResponseEntity<BfResponse<?>> login(@RequestParam(name = "code") String code) {

        return ResponseEntity.status(HttpStatus.OK)
            .body(new BfResponse<>(GlobalSuccessCode.CREATE,
                Map.of("id", memberService.getUserInfoFromResourceServer(code))));
    }

}
