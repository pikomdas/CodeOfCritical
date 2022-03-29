package com.codeOfCritical.services;


import com.codeOfCritical.domain.Deviations;
import org.springframework.stereotype.Component;

@Component
public interface DeviationsService {
    Integer listAllScenarios();

    Deviations getDeviationsByScenarioName(String name);

    Deviations saveDeviations(Deviations Deviations);
}
