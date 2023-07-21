package com.belajar.session.repository;

import com.belajar.session.entity.Session;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SessionRepository extends CrudRepository<Session,Long>{
    Session findByUserId(String userId);
}
