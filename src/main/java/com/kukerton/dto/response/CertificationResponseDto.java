package com.kukerton.dto.response;

import com.kukerton.domain.entity.Certification;
import io.swagger.v3.oas.annotations.media.Schema;
import java.time.LocalDate;
import lombok.Builder;

@Builder
public record CertificationResponseDto(

    String taskTitle,
    String imageUrl,
    String userTitle,
    LocalDate localDate,
    String review
) {

    public static CertificationResponseDto fromEntity(Certification certification) {
        return CertificationResponseDto.builder()
            .taskTitle(certification.getTaskTitle())
            .imageUrl(certification.getImg_url())
            .userTitle(certification.getUserTitle())
            .review(certification.getReview())
            .localDate(certification.getLocalDate())
            .build();
    }
}
