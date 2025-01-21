package com.melvin.banking.service;

import com.melvin.banking.common.constants.Constants;
import com.melvin.banking.common.exception.UserAlreadyExistsException;
import com.melvin.banking.model.User;
import com.melvin.banking.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public User createUser(final User user) {
        return userRepository.save(user);
    }


    public boolean validateUser(final User user) {
        if (user == null) {
            throw new IllegalArgumentException(Constants.ErrorMessage.INVALID_USER_DETAILS);
        }
        return userRepository.existsByEmail(user.getEmail()) && userRepository.existsByUsername(user.getUsername());
    }
}
