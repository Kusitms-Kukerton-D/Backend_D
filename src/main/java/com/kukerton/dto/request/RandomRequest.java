package com.kukerton.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RandomRequest {

    @NotNull(message = "분야선택 항목은 필수입니다.")
    private String category;

    @NotNull(message = "희망소요 시간 항목(시)은 필수입니다.")
    private Integer hour;

    @NotNull(message = "희망소요 시간 항목(분)은 필수입니다.")
    private Integer minute;

}
