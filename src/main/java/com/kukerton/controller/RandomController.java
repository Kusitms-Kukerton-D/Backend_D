package com.kukerton.controller;

import com.kukerton.dto.request.RandomRequest;
import com.kukerton.global.enums.GlobalSuccessCode;
import com.kukerton.global.exception.RandomException;
import com.kukerton.global.response.BfResponse;
import com.kukerton.service.RandomService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

import static com.kukerton.global.enums.RandomErrorCode.RANDOM_INPUT_FORMAT;

@Slf4j
@RestController
@RequestMapping("/random")
@RequiredArgsConstructor
@Tag(name="랜덤박스 API" , description = "할 일 랜덤박스 API 입니다.")
public class RandomController {

    private final RandomService randomService;

    @Operation(summary = "할 일 랜덤박스 API 입니다", description = "분야 선택, 희망 소요 시간 정보를 body에 담아 주시면 됩니다.\n" +
            "category는 Interested 혹은 Restrained 둘 중에 하나만 해주시면됩니다. \n" +
            "만약 시간 무관 항목을 선택하게되면 hour와 minute은 둘 다 0으로 해주시면 됩니다. hour가 없다면 hour는 0으로 해주시면 되고, minute이 없다면 minute을 0으로 해주시면 됩니다.")
    @PostMapping("")
    public ResponseEntity<BfResponse<?>> random(@Validated @RequestBody RandomRequest randomRequest, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            throw new RandomException(RANDOM_INPUT_FORMAT);
        }

        return ResponseEntity.status(HttpStatus.OK)
                .body(new BfResponse<>(GlobalSuccessCode.SUCCESS,
                        Map.of("content", randomService.getRandomTask(randomRequest))));
    }

}
