package com.loctp.phr_system.model;

import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Entity
@Table(name = "account")
public class Account {
    @Id
    @Column(name = "Id")
    private String id;

    @Column(name = "Username")
    private String username;

    @Column(name = "Password")
    private String password;

    @Column(name = "Role_Id")
    private String roleId;

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRoleId() {
        return this.roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

}
