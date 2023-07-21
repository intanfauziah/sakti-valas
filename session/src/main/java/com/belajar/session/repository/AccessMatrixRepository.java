package com.belajar.session.repository;

import com.belajar.session.entity.AccessMatrix;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccessMatrixRepository extends CrudRepository<AccessMatrix, Long> {
    List<AccessMatrix> findByUrlRest(String urlRest);
}