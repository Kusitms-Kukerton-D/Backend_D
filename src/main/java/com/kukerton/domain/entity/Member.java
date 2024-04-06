package com.kukerton.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Member {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nickname;

    private Long authId;

    private Integer level;

    private Timestamp start_time;

    private Timestamp end_time;

    @OneToMany(mappedBy = "certification", orphanRemoval = true, cascade = CascadeType.ALL)
    private List<Certification> certifications = new ArrayList<>();

    @OneToMany(mappedBy = "config", orphanRemoval = true, cascade = CascadeType.ALL)
    private List<Config> configs = new ArrayList<>();

    @OneToMany(mappedBy = "coupon", orphanRemoval = true, cascade = CascadeType.ALL)
    private List<Coupon> coupons = new ArrayList<>();
}
