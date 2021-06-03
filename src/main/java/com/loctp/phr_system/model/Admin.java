package com.loctp.phr_system.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "admin")
public class Admin {

    @Id
    @Column(name = "Id")
    private String id;

    @Column(name = "Account_Id")
    private String account_id;

    @Column(name = "Image")
    private String image;

    @Column(name = "Name")
    private String name;

}
