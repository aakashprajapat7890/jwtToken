package com.jwt.exampe.service;

import com.jwt.exampe.entity.UserInfo;
import com.jwt.exampe.exception.DuplicateEntryException;
import com.jwt.exampe.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;


    public UserInfo createUser(UserInfo userInfo)
    {
        try {
            userInfo.setUserPass(passwordEncoder.encode(userInfo.getUserPass()));
            return userRepo.save(userInfo);
        } catch (DuplicateEntryException exception) {
            throw exception;
        }
    }

    public List<UserInfo> getAllUser()
    {
        return userRepo.findAll();
    }
    public UserInfo getById(Long userId)
    {
        return userRepo.findById(userId).get();
    }

    public  Optional<UserInfo> getUserByName(String userName)
    {
        return userRepo.findByUserName(userName);
    }

    public Optional<UserInfo> getByEmail(String userEmail)
    {
        return userRepo.findByUserEmail(userEmail);
    }

    public  void deleteByUserId(Long userId)
    {
        userRepo.deleteById(userId);
    }
    public  void deleteAllUserInfo()
    {
        userRepo.deleteAll();
    }

    public UserInfo  updateAndSave(Long userId,UserInfo userInfo)
    {
        UserInfo userInfo1 = userRepo.findById(userId).orElse(null);
        if(userInfo1!=null)
        {
            userInfo1.setUserName(userInfo.getUserName());
            userInfo1.setUserEmail(userInfo.getUserEmail());
            userInfo1.setUserPass(userInfo.getUserPass());
            return userRepo.save(userInfo1);
        }
        return null;
    }

}
