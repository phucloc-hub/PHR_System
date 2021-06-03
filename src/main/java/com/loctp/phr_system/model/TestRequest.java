package com.loctp.phr_system.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
@Getter
@Setter
@Entity
@Table(name = "test_request")
public class TestRequest {
    @Id
    @Column(name = "Id")
    private Integer id;

    @Column(name = "TimeStart")
    private java.sql.Timestamp timeStart;

    @Column(name = "TimeFinish")
    private java.sql.Timestamp timeFinish;

    @Column(name = "Description")
    private String description;

    @Column(name = "Doctor_Id")
    private Integer doctorId;

    @Column(name = "Patient_Id")
    private Integer patientId;


}
