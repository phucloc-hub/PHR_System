package com.loctp.phr_system.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "family_group")
public class FamilyGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer id;

    @Column(name = "Name")
    private String name;

    @Column(name = "Status")
    private String status;

    @Column(name = "Avatar")
    private String avatar;

    @OneToMany(mappedBy = "familyGroup")
    private List<UserFamilyGroup> userFamilyGroupList;

    @OneToMany(mappedBy = "familyGroup")
    private  List<RequestGroup> requestGroup;
}
