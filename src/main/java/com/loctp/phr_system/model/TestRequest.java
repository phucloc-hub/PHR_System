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

    @Column(name = "TimeStart")
    private java.sql.Timestamp timeStart;

    @Column(name = "TimeFinish")
    private java.sql.Timestamp timeFinish;

    @Column(name = "Description")
    private String description;

    @Column(name = "Doctor_Id", insertable = false, updatable = false)
    private Integer doctorId;

    @Column(name = "Patient_Id", insertable = false, updatable = false)
    private Integer patientId;

    @OneToMany(mappedBy = "testRequest")
    private List<PackageRequest> packageRequestList;

    @OneToOne
    @JoinColumn(name = "Patient_Id")
    private Patient patient;

    @OneToOne(mappedBy = "testRequest")
    private Examination examination;

    @OneToOne
    @JoinColumn(name = "Doctor_Id")
    private Doctor doctor;

}
