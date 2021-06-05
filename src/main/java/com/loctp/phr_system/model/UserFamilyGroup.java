package com.loctp.phr_system.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
@Getter
@Setter
@Entity
@Table(name = "user_family_group")
public class UserFamilyGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer id;

    @Column(name = "Group_Role")
    private String groupRole;

    @Column(name = "Patient_Id", insertable = false, updatable = false)
    private Integer patientId;

    @Column(name = "Family_Group_Id", insertable = false, updatable = false)
    private Integer familyGroupId;

    @ManyToOne
    @JoinColumn(name = "Patient_Id")
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "Family_Group_Id")
    private FamilyGroup familyGroup;
}
