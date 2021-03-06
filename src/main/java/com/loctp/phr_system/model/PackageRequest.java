package com.loctp.phr_system.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
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

    @ManyToOne
    @JoinColumn(name = "TestRequest_Id", insertable = false, updatable = false)
    private TestRequest testRequest;

    @ManyToOne
    @JoinColumn(name = "Test_Id", insertable = false, updatable = false)
    private Test test;

    @ManyToOne
    @JoinColumn(name = "Package_Id", insertable = false, updatable = false)
    private Package aPackage;

}
