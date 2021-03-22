package com.example.exam.service;

import com.example.exam.model.entity.User;
import com.example.exam.model.service.UserRegisterServiceModel;
import com.example.exam.model.service.UserServiceLoginModel;

public interface UserService {

    void register(UserRegisterServiceModel userRegisterServiceModel);

    UserServiceLoginModel findByUsernameAndPassword(String username, String password);

    User findById(String id);
}
