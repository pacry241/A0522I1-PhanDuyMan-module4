package com.example.md4_case_study.model.user;

import javax.persistence.*;

@Entity
public class UserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userRoleId;

    @ManyToOne
    @JoinColumn(name = "userId")
    private AppUser appUserId;

    @ManyToOne
    @JoinColumn(name = "roleId")
    private AppRole appRoleId;

    public UserRole() {}

    public UserRole(Long userRoleId) {
        this.userRoleId = userRoleId;
    }

    public Long getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(Long userRoleId) {
        this.userRoleId = userRoleId;
    }

    public AppUser getAppUserId() {
        return appUserId;
    }

    public void setAppUserId(AppUser appUserId) {
        this.appUserId = appUserId;
    }

    public AppRole getAppRoleId() {
        return appRoleId;
    }

    public void setAppRoleId(AppRole appRoleId) {
        this.appRoleId = appRoleId;
    }
}
