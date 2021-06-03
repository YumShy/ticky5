package com.example.ticky.controller;

import com.example.ticky.domain.UserEntity;
import com.example.ticky.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.ticky.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/hello")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @GetMapping( "/{Id}")
    public @ResponseBody UserEntity show(@PathVariable long Id){ return userService.findById(Id); }

    @PostMapping("/add")
    public @ResponseBody UserEntity addUser(@RequestBody UserEntity userEntity){
        if( userService.findById(userEntity.getId()).getId()==-1){
            return userService.saveUser(userEntity);
        }
        else{
            userEntity.setId(0);
            return userService.saveUser(userEntity);
        }
    }

    @PostMapping("/update")
    public @ResponseBody UserEntity updateUser(@RequestBody UserEntity userEntity){

        return userService.saveUser(userEntity);
    }

    @PostMapping("/delete")
    public @ResponseBody void deleteUser(@RequestBody long Id){  userService.deleteUser(Id);}
}
