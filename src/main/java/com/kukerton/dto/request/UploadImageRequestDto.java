package com.kukerton.dto.request;

import java.util.List;
import org.springframework.web.multipart.MultipartFile;

public record UploadImageRequestDto(
    List<MultipartFile> images
) {

}
