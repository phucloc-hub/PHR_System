package com.loctp.phr_system.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
@Getter
@Setter
@Entity
@Table(name = "patient")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer id;

    @Column(name = "Account_Id")
    private Integer accountId;

    @Column(name = "BloodType")
    private String bloodType;

    @Column(name = "Height")
    private String height;

    @Column(name = "Weight")
    private String weight;

    @Column(name = "Medical_Note")
    private String medicalNote;

    @Column(name = "Image")
    private String image;

    @Column(name = "Name")
    private String name;

    @Column(name = "DoB")
    private String doB;

    @Column(name = "Email")
    private String email;

    @Column(name = "Address")
    private String address;

    @Column(name = "Phone")
    private String phone;
}
