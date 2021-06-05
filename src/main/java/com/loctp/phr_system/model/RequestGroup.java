package com.loctp.phr_system.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
@Getter
@Setter
@Entity
@Table(name = "request_group")
public class RequestGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer id;

    @Column(name = "Date_Request")
    private java.sql.Date dateRequest;

    @Column(name = "Status")
    private String status;

    @Column(name = "Patient_Id", insertable = false, updatable = false)
    private Integer patientId;

    @Column(name = "Family_Group_Id", insertable = false, updatable = false)
    private Integer familyGroupId;

    @OneToOne
    @JoinColumn(name = "Patient_Id")
    private Patient patient;

    @OneToOne
    @JoinColumn(name = "Family_Group_Id")
    private FamilyGroup familyGroup;

}
