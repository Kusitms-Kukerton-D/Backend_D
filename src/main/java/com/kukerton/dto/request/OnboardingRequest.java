package com.kukerton.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.kukerton.global.enums.Category;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OnboardingRequest{

    @JsonProperty("user_id")
    @NotNull(message = "사용자 ID는 필수 항목입니다.")
    @Positive(message = "사용자 ID는 음수일 수 없습니다.")
    Long user_id;

    @NotNull(message = "interested_categories는 필수 항목입니다.")
    List<String> interested_categories;

    @NotNull(message = "restrained_categories는 필수 항목입니다.")
    List<String> restrained_categories;
}
