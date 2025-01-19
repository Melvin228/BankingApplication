package com.melvin.banking.seeder;

import com.melvin.banking.model.User;
import com.melvin.banking.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;

@Component
@RequiredArgsConstructor
@Transactional
public class UserSeeder implements ApplicationRunner {

    private final UserRepository userRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        seedUsers();
    }

    private final void seedUsers() {
        if (userRepository.count() == 0) {
            User user1 = new User();
            user1.setEmail("tester1@gmail.com");
            user1.setUsername("tester1");
            user1.setPhoneNumber("0187771313");

            User user2 = new User();
            user2.setEmail("tester2@gmail.com");
            user2.setUsername("tester2");
            user2.setPhoneNumber("0187771313");

            User user3 = new User();
            user3.setEmail("tester3@gmail.com");
            user3.setUsername("tester3");
            user3.setPhoneNumber("0187771313");
            userRepository.saveAll(Arrays.asList(user1, user2, user3));
        }
    }
}
