package com.kukerton.dto.response;

import java.util.List;
import lombok.Builder;

@Builder
public record MemberResponseDto(
    String name,
    Integer level,

    Integer randomCount,
    Long certificateCount,

    Integer coupon,

    List<CertificationDto> certificationDtos

) {

}
