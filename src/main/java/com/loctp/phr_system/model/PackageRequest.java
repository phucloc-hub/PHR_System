package com.loctp.phr_system.model;

import javax.persistence.*;

@Entity
@Table(name = "package_request")
public class PackageRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer id;

    @Column(name = "TestRequest_Id")
    private Integer testRequestId;

    @Column(name = "Package_Id")
    private Integer packageId;

    @Column(name = "Test_Id")
    private Integer testId;

}
