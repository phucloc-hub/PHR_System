package com.loctp.phr_system.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "packagetest")
public class Packagetest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer id;

    @Column(name = "Package_Id")
    private Integer packageId;

    @Column(name = "Test_Id")
    private Integer testId;

   @ManyToOne
    @JoinColumn(name = "Package_Id")
    private Package aPackage;

   @ManyToOne
    @JoinColumn(name = "Test_Id")
    private Test test;

}
