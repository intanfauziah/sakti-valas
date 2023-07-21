package com.belajar.session.entity.bendahara;


import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "BEN_T_KAS_BANK_BEN_PENG")
@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class KasBankBenPeng {
//    private static final long serialVersionUID = 418113537212856984L;

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "KAS_BANK_BEN_PENG_SEQ")
    @TableGenerator(
            name = "KAS_BANK_BEN_PENG_SEQ",
            table = "BEN_SEQUENCE",
            pkColumnName = "SEQ_NAME",
            pkColumnValue = "KAS_BANK_BEN_PENG_SEQ",
            valueColumnName = "SEQ_COUNT",
            initialValue = 1,
            allocationSize = 1)
    @Column(name = "ID")
    private Long id;
    @Column(name = "CREATED_BY")
    private String createdBy;
    @Column(name = "CREATED_DATE")
    private Date createdDate;
    @Column(name = "DELETED")
    private Integer deleted;
    @Column(name = "MODIFIED_BY")
    private String modifiedBy;
    @Column(name = "MODIFIED_DATE")
    private Date modifiedDate;
    @Column(name = "VERSION")
    private Integer version;
    @Column(name = "JENIS_AKTIFITAS")
    private String jenisAktifitas;
    @Column(name = "JENIS_SP2D")
    private String jenisSP2D;
    @Column(name = "JUMLAH")
    private BigDecimal jumlah;
    @Column(name = "KATEGORI_KAS")
    private String kategoriKas;
    @Column(name = "NO_REF_GL")
    private String noRefGL;
    @Column(name = "NO_REFERENSI")
    private String noReferensi;
    @Column(name = "NO_SP2D")
    private String noSP2D;
    @Column(name = "NO_UANG_MUKA")
    private String noUangMuka;
    @Column(name = "KODE_SATKER")
    private String kodeSatker;
    @Column(name = "STATUS_HISTORI")
    private Integer statusHistori;
    @Column(name = "KODE_SUMBER_DANA")
    private String kodeSumberDana;
    @Column(name = "KODE_TAHUN_ANGGARAN")
    private String kodeTahunAnggaran;
    @Column(name = "TGL_TRANSAKSI")
    private Date tglTransaksi;
    @Column(name = "URAIAN")
    private String uraian;
    @Column(name = "NO_REGISTER")
    private String noRegister;
    @Column(name = "KODE_UNIT_TEKNIS")
    private String kodeUnitTeknis;
    @Column(name = "KODE_UNIT_TEKNIS_ASAL")
    private String kodeUnitTeknisAsal;
    @Column(name = "ID_SPP")
    private Long idSpp;
    @Column(name = "ID_REK_BANK")
    private Long idRekBank;
    @Column(name = "ID_UANG_MUKA")
    private Long idUangMuka;
    @Column(name = "TGL_BUKU")
    private Date tglBuku;
}
