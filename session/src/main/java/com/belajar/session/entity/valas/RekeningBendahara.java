package com.belajar.session.entity.valas;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "BEN_R_REKENING_BENDAHARA")
@Getter
@Setter
public class RekeningBendahara {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @Column(name = "CREATED_BY")
    private String createdBy;
    @Column(name = "CREATED_DATE")
    private Date createdDate;
    @Column(name = "DELETED")
    private Long deleted;
    @Column(name = "MODIFIED_BY")
    private String modifiedBy;
    @Column(name = "MODIFIED_DATE")
    private Date modifiedDate;
    @Column(name = "VERSION")
    private Long version;
    @Column(name = "KODE")
    private String kode;
    @Column(name = "KODE_SATKER")
    private String kodeSatker;
    @Column(name = "NAMA_BANK")
    private String namaBank;
    @Column(name = "NAMA_REK")
    private String namaRek;
    @Column(name = "NO_IZIN")
    private String noIzin;
    @Column(name = "NOREK")
    private String norek;
    @Column(name = "TGL_IZIN")
    private Date tglIzin;
    @Column(name = "OWNER")
    private String owner;
    @Column(name = "KODE_UNIT_TEKNIS")
    private String kodeUnitTeknis;
    @Column(name = "STATUS_REKENING")
    private Integer statusRekening;
    @Column(name = "DESC_STATUS_REKENING")
    private String descStatusRekening;
}
