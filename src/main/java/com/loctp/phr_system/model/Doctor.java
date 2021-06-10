package com.loctp.phr_system.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "doctor")
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer id;

    @Column(name = "Account_Id")
    private Integer accountId;

    @Column(name = "Image")
    private String image;

    @Column(name = "Name")
    private String name;

    @Column(name = "Phone")
    private String phone;

    @Column(name = "Email")
    private String email;

    @Column(name = "Clinic_Id")
    private Integer clinicId;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Account_Id", insertable = false, updatable = false)
    private Account account;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Clinic_Id", insertable = false, updatable = false)
    private Clinic clinic;

    @OneToOne(mappedBy = "doctor")
    private TestRequest testRequest;
}
