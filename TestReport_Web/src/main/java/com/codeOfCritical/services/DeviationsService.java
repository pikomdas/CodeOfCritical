package com.codeOfCritical.services;


import com.codeOfCritical.data.ReadData;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DeviationsService {
    List<String> listAllFailedScenarios();

    List<Integer> listOfAllScenarios();

    ReadData readJSON();
}
