package com.example.exam.service.impl;

import com.example.exam.model.entity.User;
import com.example.exam.model.service.UserRegisterServiceModel;
import com.example.exam.model.service.UserServiceLoginModel;
import com.example.exam.repository.UserRepository;
import com.example.exam.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void register(UserRegisterServiceModel userRegisterServiceModel) {
        if (userRepository.findByUsername(userRegisterServiceModel.getUsername()) == null) {
        userRepository.save(modelMapper.map(userRegisterServiceModel, User.class));
        }
        else {
            throw new IllegalArgumentException("The user is already registered");
        }
    }

    @Override
    public UserServiceLoginModel findByUsernameAndPassword(String username, String password) {
        return userRepository.findByUsernameAndPassword(username, password)
                .map(user ->
                        modelMapper.map(user, UserServiceLoginModel.class))
                .orElse( null);
    }

    @Override
    public User findById(String id) {

        return userRepository.getById(id);
    }
}
