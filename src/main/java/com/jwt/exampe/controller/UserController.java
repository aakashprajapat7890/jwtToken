package com.jwt.exampe.controller;

import com.jwt.exampe.entity.UserInfo;
import com.jwt.exampe.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user-info")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/save-user")
    public ResponseEntity<UserInfo> saveUser(@Valid @RequestBody UserInfo userInfo)
    {
        UserInfo user = userService.createUser(userInfo);
        return new ResponseEntity<>(userInfo, HttpStatus.CREATED);
    }

    @GetMapping("/getAllUser")
    public List<UserInfo> getAllUser()
    {
        return userService.getAllUser();
    }

    @GetMapping("/getByUserId/{userName}")
    public  UserInfo getUserById(@PathVariable Long userId)
    {
        return userService.getById(userId);
    }

    @GetMapping("/getByUserEmail/{userEmail}")
    public  UserInfo getUserByEmail(@PathVariable String userEmail)
    {
        return userService.getByEmail(userEmail).get();
    }

    @GetMapping("/getByUserName/{userName}")
    public  UserInfo getUserByName(@PathVariable String userName)
    {
        return userService.getUserByName(userName).get();
    }
    @DeleteMapping("/deletedUserById/{userId}")
    public  String deleteUserById(@PathVariable Long userId)
    {
        userService.deleteByUserId(userId);
        return "user deleted sucessfully";
    }
    @DeleteMapping("/deletedAllUser")
    public  String deleteAllUsers()
    {
        userService.deleteAllUserInfo();
        return "Deleted All Users suceessfully";
    }
    @PutMapping("/updateUser/{userId}")
    public UserInfo updateAndSave(@RequestBody UserInfo userInfo,@PathVariable Long userId)
    {
        return userService.updateAndSave(userId,userInfo);
    }

}
