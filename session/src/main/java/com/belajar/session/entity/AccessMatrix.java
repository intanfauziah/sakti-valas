package com.belajar.session.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "ADM_R_ACCESS_MATRIX")
@Getter
@Setter
public class AccessMatrix {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private String id;
    @Column(name = "URL_REST")
    private String urlRest;
    @Column(name = "FORM_ID")
    private Integer formId;
    @Column(name = "ACL_VALUE")
    private Integer aclValue;
}