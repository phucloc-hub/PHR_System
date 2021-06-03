package com.loctp.phr_system.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "disease_health_record")
public class DiseaseHealthRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer id;

    @Column(name = "Patient_Id")
    private Integer patientId;

    @Column(name = "Disease_Id")
    private Integer diseaseId;

    @ManyToOne
    @JoinColumn(name = "Disease_Id")
    private Disease disease;

    @ManyToOne
    @JoinColumn(name = "Patient_Id")
    private Patient patient;
}
