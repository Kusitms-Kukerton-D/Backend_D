package com.kukerton.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;

public record KakaoAccount(
    @JsonProperty("nick_name")
    @NotNull(message = "이름은 필수입니다.")
    String name,

    @JsonProperty("email")
    @NotNull(message = "email은 필수입니다.")
    String email,

    @JsonProperty("profile")
    @NotNull(message = "profile은 필수입니다.")
    Profile profile

) {

}
