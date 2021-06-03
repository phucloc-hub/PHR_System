package com.loctp.phr_system.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "examination")
public class Examination {
    @Id
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

    @Column(name = "TestRequest_Id")
    private Integer testRequestId;
}
