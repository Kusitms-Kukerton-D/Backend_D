package com.kukerton.service;

import com.kukerton.domain.entity.Certification;
import com.kukerton.domain.entity.Config;
import com.kukerton.domain.entity.Store;
import com.kukerton.domain.entity.Task;
import com.kukerton.domain.repository.*;
import com.kukerton.dto.request.RandomRequest;
import com.kukerton.global.response.StoreResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class RandomService {

    private final ConfigRepository configRepository;
    private final TaskRepository taskRepository;
    private final StoreRepository storeRepository;
    private final CouponRepository couponRepository;
    private final CertificationRepository certificationRepository;
    private final MemberRepository memberRepository;

    public String getRandomTask(RandomRequest randomRequest) {

        String isInterested = randomRequest.getCategory();

        List<Config> configList = configRepository.findAllByIsWant(
            isInterested.equals("Interested"));
        List<Task> taskList = new ArrayList<>();
        configList
            .forEach(
                config -> taskList.addAll(taskRepository.findAllByCategory(config.getCategory())));

        List<Task> newTaskList = taskList.stream()
            .filter(task -> task.getHour() <= randomRequest.getHour())
            .filter(task -> task.getHour().equals(randomRequest.getHour())
                && task.getMinute() <= randomRequest.getMinute())
            .toList();

        if (newTaskList.isEmpty()) {
            return null;
        }

        //System.out.println(newTaskList.size());
        Random rnd = new Random();
        rnd.setSeed(System.currentTimeMillis());

        Task result = newTaskList.get(rnd.nextInt(newTaskList.size()));

        certificationRepository.save(
            Certification.builder()
                .taskTitle(result.getContent())
                .content(result.getTitle())
                .member(memberRepository.findById(randomRequest.getUser_id()).orElse(null))
                .build());

        return result.getContent();
    }

    public List<StoreResponse> getStore() {
        List<Store> storeList = storeRepository.findAll();

        return storeList.stream()
            .map(store -> StoreResponse.builder()
                .store_name(store.getName())
                .category(store.getCategory())
                .is_opened(store.getIs_opened())
                .end_time(store.getEnd_time())
                .discount(couponRepository.findByStoreId(store.getId()) == null ? null
                    : couponRepository.findByStoreId(store.getId()).getPrice())
                .build()).toList();

    }
}
