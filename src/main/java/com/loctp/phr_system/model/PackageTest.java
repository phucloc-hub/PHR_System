package com.loctp.phr_system.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "package_test")
public class PackageTest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer id;

    @Column(name = "Package_Id")
    private Integer packageId;

    @Column(name = "Test_Id")
    private Integer testId;

    @ManyToOne
    @JoinColumn(name = "Package_Id", insertable = false, updatable = false)
    private Package aPackage;

    @ManyToOne
    @JoinColumn(name = "Test_Id", insertable = false, updatable = false)
    private Test test;

}
