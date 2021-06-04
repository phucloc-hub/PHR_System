package com.loctp.phr_system.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "account")
public class Account {
    @Id
    @Column(name = "Id", nullable = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(name = "Username")
    private String username;

    @Column(name = "Password")
    private String password;

    @Column(name = "Role_Id")
    private String roleId;

    @OneToOne(mappedBy = "account")
    private Admin admin;

    @OneToOne(mappedBy = "account")
    private Doctor doctor;

    @OneToOne(mappedBy = "account")
    private Patient patient;

    @OneToOne(mappedBy = "account")
    private Receptionist receptionist;
}
