package com.kukerton.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;

public record Profile(
    @JsonProperty("nickname")
    @NotNull(message = "닉네임은 필수입니다.")
    String nickname
) {

}
