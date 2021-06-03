package com.loctp.phr_system.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
@Getter
@Setter
@Entity
@Table(name = "packagetest")
public class Packagetest {
    @Id
    @Column(name = "Id")
    private Integer id;

    @Column(name = "Package_Id")
    private Integer packageId;

    @Column(name = "Test_Id")
    private Integer testId;

}
