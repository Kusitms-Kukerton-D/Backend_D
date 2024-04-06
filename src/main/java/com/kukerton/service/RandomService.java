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

        taskList
                .forEach(task -> {
                    if(task.getHour() > randomRequest.getHour()){
                        taskList.remove(task);
                    }
                    else if(task.getHour().equals(randomRequest.getHour())){
                        if(task.getMinute() > randomRequest.getMinute()){
                            taskList.remove(task);
                        }
                    }
                });

        System.out.println(taskList.size());
        Random rnd = new Random();
        rnd.setSeed(System.currentTimeMillis());
        return taskList.get(rnd.nextInt(taskList.size())).getContent();

    }
}
