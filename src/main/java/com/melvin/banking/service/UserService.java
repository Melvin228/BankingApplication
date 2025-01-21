package com.melvin.banking.service;

import com.melvin.banking.model.User;

public interface UserService {
    User createUser(User user);
    boolean validateUser(User user);
}
