package com.kukerton.domain.repository;

import com.kukerton.domain.entity.Config;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ConfigRepository extends JpaRepository<Config, Long> {
    List<Config> findAllByIsWant(Boolean isWant);
}
