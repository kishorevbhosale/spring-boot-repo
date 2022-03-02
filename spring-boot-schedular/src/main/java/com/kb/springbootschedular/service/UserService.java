package com.kb.springbootschedular.service;

import com.kb.springbootschedular.entity.User;
import com.kb.springbootschedular.repository.UserRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Random;

@Slf4j
@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;

    // Scheduled a job to add the object in db (Every 5 sec)
    @Scheduled(fixedRate = 5000)
    public void add2DbJob() {
        User user = User.builder()
                .name("user" + new Random().nextInt(12334))
                .build();
        userRepo.save(user);
        log.info("add service call in {}, user details : {}", new Date(), user.getName());
    }

    // Scheduled a job to fetch the object from db (Every 15 sec)
    @Scheduled(cron = "0/15 * * * * *")
    public void fetchFromDb() {
        List<User> users = userRepo.findAll();
        log.info("Fetched service call in {}", new Date());
        log.info("Number of records fetched : {}", users.size());
    }
}
