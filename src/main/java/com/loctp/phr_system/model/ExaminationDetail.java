package com.loctp.phr_system.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
@Getter
@Setter
@Entity
@Table(name = "examination_detail")
public class ExaminationDetail {
    @Id
    @Column(name = "Id")
    private Integer id;

    @Column(name = "Examination_Id")
    private Integer examinationId;

    @Column(name = "Test_Id")
    private Integer testId;

    @Column(name = "Advise")
    private String advise;

    @Column(name = "Diagnose")
    private String diagnose;

    @Column(name = "Note")
    private String note;
}
