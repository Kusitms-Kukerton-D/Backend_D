package com.kukerton.dto.request;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotNull;
import java.util.List;
import org.springframework.web.multipart.MultipartFile;

public record CertificationRequestDto(

    @NotNull(message = "certification id는 필수입니다.")
    Long certificationId,
    @NotNull(message = "title은 필수입니다.")
    String title,
    @NotNull(message = "review는 필수입니다.")
    String review,
    @Nullable
    String imageUrl
) {

}
