package com.example.ticky.service;

import com.example.ticky.domain.UserEntity;

public interface UserService {
    UserEntity findById(long Id);
    UserEntity saveUser(UserEntity userEntity);
    void deleteUser(long Id);

}

