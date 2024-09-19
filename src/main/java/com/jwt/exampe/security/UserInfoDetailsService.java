package com.jwt.exampe.security;

import com.jwt.exampe.entity.UserInfo;
import com.jwt.exampe.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserInfoDetailsService implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String userEmail) throws UsernameNotFoundException {

        Optional<UserInfo> userByEmail = userRepo.findByUserEmail(userEmail);
        return userByEmail.map(UserInfoDetails::new).orElseThrow(()->new UsernameNotFoundException("user not found with this data..!! " + userEmail));
    }
}
