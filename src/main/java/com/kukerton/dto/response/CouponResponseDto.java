package com.kukerton.dto.response;

import com.kukerton.domain.entity.Coupon;
import java.time.LocalDate;
import lombok.Builder;

@Builder
public record CouponResponseDto(
    String content,

    LocalDate endDate
) {

    public static CouponResponseDto fromEntity(Coupon coupon) {
        return CouponResponseDto.builder()
            .content(coupon.getContent())
            .endDate(coupon.getEndDate())
            .build();
    }

}
