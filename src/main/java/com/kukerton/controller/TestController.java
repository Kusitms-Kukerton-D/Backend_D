package com.kukerton.controller;

import com.kukerton.domain.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/test")
@RequiredArgsConstructor
@RestController
@Slf4j
public class TestController {

    private final MemberRepository memberRepository;
    @GetMapping
    public String test(){
        log.info("controller 실행");
        return memberRepository.findById(1L).get().getName();
    }
}
