package com.belajar.session.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "ADM_R_SEC_ACL")
@Getter
@Setter
public class Acl {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Number id;
    @Column(name = "CREATED_BY")
    private String createdBy;
    @Column(name = "CREATED_DATE")
    private Date createdDate;
    @Column(name = "DELETED")
    private String deleted;
    @Column(name = "MODIFIED_BY")
    private String modifiedBy;
    @Column(name = "MODIFIED_DATE")
    private Date modifiedDate;
    @Column(name = "VERSION")
    private Number version;
    @Column(name = "ACL_OBJECT_ID")
    private Number aclObjectId;
    @Column(name = "REKAM")
    private Number rekam;
    @Column(name = "HAPUS")
    private Number hapus;
    @Column(name = "EKSEKUSI")
    private Number eksekusi;
    @Column(name = "KODE_ACL")
    private String kodeAcl;
    @Column(name = "BACA")
    private Number baca;
    @Column(name = "UBAH")
    private Number ubah;
    @Column(name = "KODE_KELOMPOK_PENGGUNA")
    private String kodeKelompokPengguna;
    @Column(name = "KODE_KELOMPOK")
    private String kodeKelompok;
}