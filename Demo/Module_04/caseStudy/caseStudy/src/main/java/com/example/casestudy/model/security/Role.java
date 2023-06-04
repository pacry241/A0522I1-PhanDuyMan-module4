package com.example.casestudy.model.security;

import javax.persistence.*;

@Entity
@Table(name = "role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer roleId;

    private String roleName;


    public Role() {
    }

    public Role(Integer role_Id, String role_Name) {
        this.roleId = role_Id;
        this.roleName = role_Name;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer role_Id) {
        this.roleId = role_Id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String role_Name) {
        this.roleName = role_Name;
    }
}
