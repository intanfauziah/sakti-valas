package com.belajar.session.repository.valas;

import com.belajar.session.entity.valas.Spp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SppRepository extends JpaRepository<Spp,Long> {
    @Query(value = "SELECT * FROM SPM_T_SPP " +
            "WHERE KD_SATKER =:kodeSatker  AND (KD_JNS_SPP = '311' OR KD_JNS_SPP = '312' OR KD_JNS_SPP = '313') " +
            "AND NILAI_SP2D <> 0 AND STS_DATA = 'SPM_STS_DATA_13'", nativeQuery = true)
    List<Spp> findSppTup(@Param("kodeSatker") String kodeSatker);

    @Query(value = "SELECT * FROM SPM_T_SPP " +
            "WHERE KD_SATKER =:kodeSatker  AND (KD_JNS_SPP = '321' OR KD_JNS_SPP = '322') " +
            "AND NILAI_SP2D <> 0 AND STS_DATA = 'SPM_STS_DATA_13'", nativeQuery = true)
    List<Spp> findSppUp(@Param("kodeSatker") String kodeSatker);
}
