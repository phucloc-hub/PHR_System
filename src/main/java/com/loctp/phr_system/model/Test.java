package com.loctp.phr_system.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "test")
public class Test {
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

    @OneToMany(mappedBy = "test")
    private List<ExaminationDetail> examinationDetail;

    @OneToMany(mappedBy = "test")
    private List<PackageTest> packageTestList;

    @OneToMany(mappedBy = "test")
    private List<PackageRequest> packageRequestList;

    @OneToMany(mappedBy = "test")
    private List<TestResultSample> testResultSample;
}
