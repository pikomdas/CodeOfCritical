package com.codeOfCritical.services;


import com.codeOfCritical.data.ReadData;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
public interface DeviationsService {

    List<String> listAllFailedScenarios();

    List<Integer> listOfAllScenarios();

    Map<String, Map<String, String>> getFieldNameWithDeviationDetails();

    Map<String, Map<String, Map<String, String>>> getdeviationDetailsWithPageName();

    ReadData readJSON();

    Set<String> getUsers();

    Set<String> getDate();

}
