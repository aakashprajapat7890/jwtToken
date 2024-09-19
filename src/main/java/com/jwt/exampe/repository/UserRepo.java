package com.jwt.exampe.repository;

import com.jwt.exampe.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<UserInfo,Long> {
    public Optional<UserInfo> findByUserEmail(String email);
    public Optional<UserInfo>  findByUserName(String userName);
}

