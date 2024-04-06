package com.kukerton.controller;

import com.kukerton.dto.request.CertificationRequestDto;
import com.kukerton.global.enums.GlobalSuccessCode;
import com.kukerton.global.response.BfResponse;
import com.kukerton.service.ImageService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import java.util.List;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/image")
@RequiredArgsConstructor
@Tag(name = "이미지 API", description = "이미지 업로드 API")
public class ImageController {

    private final ImageService imageService;

    @PostMapping()
    public ResponseEntity<BfResponse<?>> uploadImage(
        @RequestPart List<MultipartFile> images) {

        return ResponseEntity.status(HttpStatus.CREATED)
            .body(new BfResponse<>(GlobalSuccessCode.CREATE,
                Map.of("image_url", imageService.uploadImage(images))));
    }

}
