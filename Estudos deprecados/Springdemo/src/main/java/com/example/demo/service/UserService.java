package com.example.demo.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.api.model.User;

@Service
public class UserService {

    private List<User> userList;

    public UserService() {
        userList = new ArrayList<>();

        User user1 = new User(1, "Ida1", 321, "Ida");
        User user2 = new User(2, "Ida2", 322, "Ida");
        User user3 = new User(3, "Ida3", 323, "Ida");
        User user4 = new User(4, "Ida4", 324, "Ida");
        User user5 = new User(5, "Ida5", 325, "Ida");

        userList.addAll(Arrays.asList(user1, user2, user3, user4, user5));
    }

    public Optional<User> getUser(Integer id) {
        Optional optional = Optional.empty();
        for (User user : userList) {
            if (id == user.getId()) {
                optional = Optional.of(user);
                return optional;
            }
        }
            return optional;
    }
}
