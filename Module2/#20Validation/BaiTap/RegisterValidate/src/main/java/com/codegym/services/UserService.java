package com.codegym.services;

import com.codegym.models.User;

import java.util.List;

public interface UserService {
    void saveUser(User user);
    List<User> getAll();
}
