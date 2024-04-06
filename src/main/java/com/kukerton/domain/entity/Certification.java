package com.kukerton.domain.entity;

import com.kukerton.dto.request.CertificationRequestDto;
import jakarta.persistence.*;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Certification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String img_url;

    private String content;

    private String taskTitle;    // task에서 certification 변환 시 입력되는 제목

    private String userTitle;    // 인증글 생성 시 유저가 입력하는 제목

    private String review;

    private String subcontent;

    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private LocalDate localDate;

    private Boolean is_cleared;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    public void certificate(CertificationRequestDto dto) {
        this.img_url = dto.imageUrl();
        this.userTitle = dto.title();
        this.review = dto.review();
        this.localDate = LocalDate.now();
        this.is_cleared = true;
    }
}
