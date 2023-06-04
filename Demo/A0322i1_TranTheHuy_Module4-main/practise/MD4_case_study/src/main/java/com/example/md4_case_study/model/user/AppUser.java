package com.example.md4_case_study.model.user;

import javax.persistence.*;

@Entity
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(name = "user_name", columnDefinition = "varchar(30)", nullable = false)
    private String userName;

    @Column(name = "Encryted_Password", columnDefinition = "varchar(60)", nullable = false)
    private String password;

    @Column(name = "enable", columnDefinition = "bit", nullable = false)
    private Boolean enable;

    public AppUser() {}

    public AppUser(Long userId, String userName, String password, Boolean enable) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.enable = enable;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getEnable() {
        return enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }
}
