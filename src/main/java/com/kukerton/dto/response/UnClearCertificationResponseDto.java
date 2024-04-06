package com.kukerton.dto.response;

import lombok.Builder;

@Builder
public record UnClearCertificationResponseDto(
    Long certificationId,
    String taskTitle
) {

}
