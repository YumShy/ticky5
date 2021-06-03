package com.example.ticky.service.impl;

import com.example.ticky.domain.UserEntity;
import com.example.ticky.repository.UserRepository;
import com.example.ticky.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

//    public UserServiceImpl(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }

    @Override
    public UserEntity findById(long Id) {
        try {
            UserEntity user_found = userRepository.findById(Id).get();
            return user_found;
        }
       catch (Exception e){
            UserEntity userEntity= new UserEntity();
            userEntity.setId(-1);
            return  userEntity;
       }

    }

    @Override
    public UserEntity saveUser(UserEntity userEntity) throws RuntimeException {
       if(userEntity.getAge() < 18){
            throw new RuntimeException("<20");
        }
        userRepository.save(userEntity);
        return userEntity;
    }

    @Override
    public void deleteUser(long Id) {
        userRepository.deleteById(Id);
    }


}
