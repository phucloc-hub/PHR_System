package com.loctp.phr_system.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "examination")
public class Examination {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer id;

    @Column(name = "TimeStart")
    private java.sql.Timestamp timeStart;

    @Column(name = "TimeFinish")
    private java.sql.Timestamp timeFinish;

    @Column(name = "Type")
    private String type;

    @Column(name = "Diagnose")
    private String diagnose;

    @Column(name = "TestRequest_Id", insertable = false, updatable = false)
    private Integer testRequestId;

   @OneToOne(mappedBy = "examination")
    private Rating rating;

    @OneToMany(mappedBy = "examination")
    private List<ExaminationDetail> examinationDetailList;

    @OneToOne
    @JoinColumn(name = "TestRequest_Id")
    private TestRequest testRequest;



}
