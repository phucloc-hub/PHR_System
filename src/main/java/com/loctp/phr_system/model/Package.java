package com.loctp.phr_system.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "package")
public class Package {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer id;

    @Column(name = "Name")
    private String name;

    @Column(name = "Status")
    private String status;

    @Column(name = "Description")
    private String description;

    @OneToMany(mappedBy = "aPackage")
    private List<PackageTest> packageTestList;

    @OneToMany(mappedBy = "aPackage")
    private List<PackageRequest> packageRequestList;
}
