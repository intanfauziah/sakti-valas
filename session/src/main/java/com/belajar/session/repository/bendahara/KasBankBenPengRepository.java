package com.belajar.session.repository.bendahara;

import com.belajar.session.entity.bendahara.KasBankBenPeng;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KasBankBenPengRepository extends JpaRepository<KasBankBenPeng,Long> {

    @Query(value = "SELECT * FROM BEN_T_KAS_BANK_BEN_PENG a WHERE a.KODE_SATKER=:kodeSatker AND a.KODE_TAHUN_ANGGARAN=:kodeTahunAnggaran AND a.NO_SP2D is not null AND a.NO_SP2D != 'MIGRASI' AND a.DELETED  = 0", nativeQuery = true)
    List<KasBankBenPeng> findBank(@Param("kodeSatker") String kodeSatker,
                                  @Param("kodeTahunAnggaran") String kodeTahunAnggaran);

    @Query(value = "SELECT * FROM BEN_T_KAS_BANK_BEN_PENG a WHERE a.KODE_SATKER='017312' AND a.KODE_TAHUN_ANGGARAN='2022' AND a.NO_SP2D is not null AND a.NO_SP2D != 'MIGRASI' AND a.DELETED  = 0", nativeQuery = true)
    List<KasBankBenPeng> getBankTest();

}
