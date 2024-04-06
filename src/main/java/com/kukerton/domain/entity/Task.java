package com.kukerton.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String  content;

    private String  category;

    @OneToMany(mappedBy = "task", orphanRemoval = true, cascade = CascadeType.ALL)
    private List<Task> tasks = new ArrayList<>();
}
