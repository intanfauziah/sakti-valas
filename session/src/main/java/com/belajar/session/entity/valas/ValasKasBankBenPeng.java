package com.belajar.session.entity.valas;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "BEN_T_VALAS_KAS_BANK_BEN_PENG")
@Getter
@Setter
public class ValasKasBankBenPeng {
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
    @Column(name = "KODE_SATKER")
    private String kodeSatker;
    @Column(name = "KATEGORI_KAS")
    private String kategoriKas;
    @Column(name = "KODE_MATA_UANG")
    private String kodeMataUang;
    @Column(name = "KODE_JENIS_KAS")
    private String kodeJenisKas;
    @Column(name = "NOMOR_REFERENSI")
    private String nomorReferensi;
    @Column(name = "NOMOR_SP2D")
    private String nomorSp2d;
    @Column(name = "KODE_SUMBER_DANA")
    private String kodeSumberDana;
    @Column(name = "MATA_UANG")
    private String mataUang;
    @Column(name = "JUMLAH")
    private BigDecimal jumlah;
    @Column(name = "NOMOR_REFERENSI_GL")
    private String nomorReferensiGl;
    @Column(name = "NILAI_KURS")
    private BigDecimal nilaiKurs;
    @Column(name = "SALDO")
    private BigDecimal saldo;
    @Column(name = "URAIAN")
    private String uraian;
}
