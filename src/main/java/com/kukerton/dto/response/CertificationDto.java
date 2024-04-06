package com.kukerton.dto.response;

import lombok.Builder;

@Builder
public record CertificationDto(
    Long certificationId,
    String imageUrl
) {

}
