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

    @Column(name = "Date")
    private java.sql.Date date;

    @Column(name = "Type")
    private String type;

    @Column(name = "Diagnose")
    private String diagnose;

    @Column(name = "Test_Request_Id")
    private Integer testRequestId;

   @OneToOne(mappedBy = "examination")
    private Rating rating;

    @OneToOne(mappedBy = "examination")
    private ExaminationDetail examinationDetailList;

    @OneToOne
    @JoinColumn(name = "Test_Request_Id", insertable = false, updatable = false)
    private TestRequest testRequest;



}
