package com.jwt.exampe.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long userId;

    @NotNull
    @Size(min=2,max = 15)
    private  String userName;

    @NotNull
    @Email
    @Column(name ="userEmail" ,unique = true)
    private String userEmail;

    @NotNull
    private  String  userPass;
}
