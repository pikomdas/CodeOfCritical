package com.codeOfCritical.repositories;

import com.codeOfCritical.domain.Deviations;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WebReport extends CrudRepository<Deviations, Integer> {

}
