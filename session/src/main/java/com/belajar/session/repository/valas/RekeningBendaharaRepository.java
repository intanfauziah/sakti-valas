package com.belajar.session.repository.valas;

import com.belajar.session.entity.valas.RekeningBendahara;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RekeningBendaharaRepository extends JpaRepository<RekeningBendahara,Long> {
    @Query(value = "SELECT* FROM BEN_R_REKENING_BENDAHARA " +
            "WHERE KODE_SATKER =:kodeSatker AND  OWNER = '1'", nativeQuery = true)
    List<RekeningBendahara> findRekBank(@Param("kodeSatker") String kodeSatker);

    @Query(value = "SELECT* FROM BEN_R_REKENING_BENDAHARA " +
            "WHERE KODE_SATKER =:kodeSatker AND  OWNER = '1'", nativeQuery = true)
    Page<RekeningBendahara> findAll(@Param("kodeSatker") String kodeSatker, Pageable page);
}
