package com.belajar.session.wrapper;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class RekeningBendaharaWrapper {
    private Integer index;
    private Long id;
    private String createdBy;
    private Date createdDate;
    private Long deleted;
    private String modifiedBy;
    private Date modifiedDate;
    private Long version;
    private String kode;
    private String kodeSatker;
    private String namaBank;
    private String namaRek;
    private String noIzin;
    private String norek;
    private Date tglIzin;
    private String owner;
    private String kodeUnitTeknis;
    private Integer statusRekening;
    private String descStatusRekening;
}
