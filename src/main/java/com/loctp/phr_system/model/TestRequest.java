package com.loctp.phr_system.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "test_request")
public class TestRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer id;


    @Column(name = "Description")
    private String description;

    @Column(name = "Doctor_Id")
    private Integer doctorId;

    @Column(name = "Patient_Id")
    private Integer patientId;

    @OneToMany(mappedBy = "testRequest")
    private List<PackageRequest> packageRequestList;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Patient_Id", insertable = false, updatable = false)
    private Patient patient;

    @OneToOne(mappedBy = "testRequest")
    private Examination examination;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Doctor_Id", insertable = false, updatable = false)
    private Doctor doctor;

}
