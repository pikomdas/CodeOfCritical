package com.codeOfCritical.repositories;

import com.codeOfCritical.domain.Deviations;
import org.springframework.data.repository.CrudRepository;

public interface WebReport extends CrudRepository<Deviations, Integer> {

}
