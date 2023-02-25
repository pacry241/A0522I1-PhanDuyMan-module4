package com.example.securityblog.model;

import javax.persistence.*;

@Entity
@Table(name = "App_User",//
        uniqueConstraints = {//
                @UniqueConstraint(name = "APP_USER_UK", columnNames = "User_Name")
        })
public class AppUser {
        @Id
        @GeneratedValue
        @Column(name = "User_Id",nullable = false)
        private Long userId;
        @Column(name = "User_Name", length = 30,nullable = false)
        private String userName;
        @Column(name = "Encryted_Password", length = 128,nullable = false)
        private String encrytedPassword;
        @Column(name = "Enable",length = 1,nullable = false)
        private boolean enable;
}
