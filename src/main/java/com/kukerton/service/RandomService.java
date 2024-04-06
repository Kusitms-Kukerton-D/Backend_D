package com.kukerton.service;

import com.kukerton.domain.entity.Config;
import com.kukerton.domain.entity.Task;
import com.kukerton.domain.repository.ConfigRepository;
import com.kukerton.domain.repository.TaskRepository;
import com.kukerton.dto.request.RandomRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Slf4j
@Service
@RequiredArgsConstructor
public class RandomService {

    private final ConfigRepository configRepository;
    private final TaskRepository taskRepository;
    public String getRandomTask(RandomRequest randomRequest) {

        String isInterested = randomRequest.getCategory();

        List<Config> configList = configRepository.findAllByIsWant(isInterested.equals("Interested"));
        List<Task> taskList = new ArrayList<>();
        configList
                .forEach(config -> taskList.addAll(taskRepository.findAllByCategory(config.getCategory())));

        List<Task> newTaskList = taskList.stream()
                        .filter(task -> task.getHour() <= randomRequest.getHour())
                        .filter(task -> task.getHour().equals(randomRequest.getHour()) && task.getMinute() <= randomRequest.getMinute())
                        .toList();


        if(newTaskList.isEmpty()){
            return null;
        }

        //System.out.println(newTaskList.size());
        Random rnd = new Random();
        rnd.setSeed(System.currentTimeMillis());
        return newTaskList.get(rnd.nextInt(newTaskList.size())).getContent();

    }
}
