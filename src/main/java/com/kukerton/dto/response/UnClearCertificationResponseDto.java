package com.kukerton.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UnClearCertificationResponseDto {

    private Long certificationId;
    private String taskTitle;
    private String content;
    private String imageUrl;

}
