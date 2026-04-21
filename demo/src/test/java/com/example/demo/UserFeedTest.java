package com.example.demo;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import com.example.demo.entity.feed.FeedEntity;
import com.example.demo.entity.user.UserEntity;
import com.example.demo.repository.FeedRepository;
import com.example.demo.repository.UserRepository;

import jakarta.transaction.Transactional;

@SpringBootTest
public class UserFeedTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private FeedRepository feedRepository;

    @Test
    @Transactional
    @Rollback(false)
    void oneToManyTest() {
        UserEntity user = new UserEntity();
        FeedEntity feed = new FeedEntity();

        user.setUserName("Tips Java");
        user.setUserEmail("tipsjava@example.com");

        feed.setTitle("feed 01");
        feed.setDescription("This is a test feed");
        user.setFeedList(List.of(feed));
        feed.setUser(user);
        userRepository.save(user);
        feedRepository.save(feed);
    }

    @Test
    @Transactional
    @Rollback(false)
    void oneToManyTestTwo() {
        UserEntity user = new UserEntity();
        FeedEntity feed = new FeedEntity();

        user.setUserName("Tips Go");
        user.setUserEmail("tipsgo@example.com");

        feed.setTitle("feed 02");
        feed.setDescription("This is a test feed");
        user.setFeedList(List.of(feed));
        feed.setUser(user);
        userRepository.save(user);
        // feedRepository.save(feed);
    }

    @Test
    @Transactional
    void selectOneToManyTest() {
        UserEntity user = userRepository.findById(3L).orElseThrow();
        System.out.println(user);
        System.out.println(user.getFeedList());
    }

}
