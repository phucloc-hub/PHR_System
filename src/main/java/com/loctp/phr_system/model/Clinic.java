package com.loctp.phr_system.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "clinic")
public class Clinic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer id;

    @Column(name = "Name")
    private String name;

    @Column(name = "Address")
    private String address;

    @Column(name = "Phone")
    private String phone;

    @Column(name = "Coordinate")
    private String coordinate;

    @Column(name = "Status")
    private String status;

    @Column(name = "Image")
    private String image;

    @Column(name = "Description")
    private String description;

    @Column(name = "Clinic_group_id")
    private Integer clinicGroupId;

    @Column(name = "District")
    private String district;

    @ManyToOne(fetch =FetchType.LAZY)
    @JoinColumn(name = "Clinic_group_id", insertable = false, updatable = false)
    private ClinicGroup clinicGroup;

    @OneToMany(mappedBy = "clinic")
    private List<Receptionist> receptionist;

    @OneToMany(mappedBy = "clinic")
    private List<Doctor> doctor;
}
