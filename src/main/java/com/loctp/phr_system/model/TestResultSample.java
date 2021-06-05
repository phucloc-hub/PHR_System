package com.loctp.phr_system.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
@Getter
@Setter
@Entity
@Table(name = "test_result_sample")
public class TestResultSample {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer id;

    @Column(name = "Index_Value_Max")
    private Double indexValueMax;

    @Column(name = "Index_Value_Min")
    private Double indexValueMin;

    @Column(name = "Type")
    private String type;

    @Column(name = "Description")
    private String description;

    @Column(name = "Test_Id", insertable = false, updatable = false)
    private Integer testId;

    @ManyToOne
    @JoinColumn(name = "Test_Id")
    private Test test;

}
