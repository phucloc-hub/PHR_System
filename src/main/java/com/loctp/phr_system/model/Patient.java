package com.loctp.phr_system.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "patient")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer id;

    @Column(name = "Account_Id")
    private Integer accountId;

    @Column(name = "blood_type")
    private String bloodType;

    @Column(name = "Height")
    private int height;

    @Column(name = "Weight")
    private int weight;

    @Column(name = "Medical_Note")
    private String medicalNote;

    @Column(name = "Image")
    private String image;

    @Column(name = "Name")
    private String name;

    @Column(name = "DoB")
    private String doB;

    @Column(name = "Email")
    private String email;

    @Column(name = "Address")
    private String address;

    @Column(name = "Phone")
    private String phone;

    @OneToMany(mappedBy = "patient")
    private List<UserFamilyGroup> userFamilyGroupList;

    @OneToOne
    @JoinColumn(name = "Account_Id", insertable = false, updatable = false)
    private Account account;

    @OneToOne(mappedBy = "patient")
    private TestRequest testRequest;

    @OneToOne(mappedBy = "patient")
    private RequestGroup requestGroup;

    @OneToMany(mappedBy = "patient")
    private List<DiseaseHealthRecord> diseaseHealthRecordList;
}
