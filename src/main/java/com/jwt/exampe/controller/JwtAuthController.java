package com.jwt.exampe.controller;

import com.jwt.exampe.entity.JwtRequest;
import com.jwt.exampe.entity.JwtResponse;
import com.jwt.exampe.jwtToken.JwtHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class JwtAuthController {


    @Autowired
    private JwtHelper jwtHelper;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/generate-token")
    public JwtResponse authenticateAndGetToken(@RequestBody JwtRequest jwtRequest)
    {
        Authentication auth=authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(jwtRequest.getUserEmail(),jwtRequest.getUserPassword()));
        if(auth.isAuthenticated()) {
            String s = jwtHelper.generateToken(jwtRequest.getUserEmail());
            JwtResponse response=JwtResponse.builder()
                    .jwtToken(s)
                    .email(jwtRequest.getUserEmail()).build();
            return response;
        }else
        {
            throw  new UsernameNotFoundException("invalid user request !!");
        }
    }
}


