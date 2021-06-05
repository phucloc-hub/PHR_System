package com.loctp.phr_system.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
@Getter
@Setter
@Entity
@Table(name = "rating")
public class Rating {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer id;

    @Column(name = "Comment")
    private String comment;

    @Column(name = "Rate")
    private Double rate;

    @Column(name = "Time")
    private java.sql.Date time;

    @Column(name = "TimeExpire")
    private java.sql.Date timeExpire;

    @Column(name = "Status")
    private String status;

    @Column(name = "Examination_Id", insertable = false, updatable = false)
    private Integer examinationId;

    @OneToOne
    @JoinColumn(name = "Examination_Id")
    private Examination examination;
}
