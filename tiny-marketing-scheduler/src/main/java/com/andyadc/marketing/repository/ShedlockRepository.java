package com.andyadc.marketing.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShedlockRepository extends CrudRepository<Shedlock, String> {
}
