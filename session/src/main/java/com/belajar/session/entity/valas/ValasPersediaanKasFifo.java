package com.belajar.session.entity.valas;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "BEN_T_VALAS_PERSEDIAAN_KAS_FIFO")
@Getter
@Setter
public class ValasPersediaanKasFifo {
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
    @Column(name = "NO_DOKUMEN")
    private String noDokumen;
    @Column(name = "JENIS_TRANSAKSI")
    private String jenisTransaksi;
    @Column(name = "MATA_UANG")
    private String mataUang;
    @Column(name = "JUMLAH")
    private BigDecimal jumlah;
    @Column(name = "MATA_UANG_ASAL")
    private String mataUangAsal;
    @Column(name = "NILAI_PENYERAHAN_UANG_ASAL")
    private Integer nilaiPenyerahanUangAsal;
    @Column(name = "KURS_THD_UANG_ASAL")
    private BigDecimal kursThdUangAsal;
    @Column(name = "KURS_EKUIVALEN_IDR")
    private BigDecimal kursEkuivalenIdr;
    @Column(name = "NILAI_EKUIVALEN_IDR")
    private BigDecimal nilaiEkuivalenIdr;
    @Column(name = "JML_PEMAKAIAN_MATA_UANG")
    private BigDecimal jmlPemakaianMataUang;
    @Column(name = "SISA_MATA_UANG")
    private BigDecimal sisaMataUang;
    @Column(name = "NO_SP2D")
    private String noSp2d;
}
