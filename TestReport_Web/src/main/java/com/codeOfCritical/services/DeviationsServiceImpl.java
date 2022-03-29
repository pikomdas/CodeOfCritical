package com.codeOfCritical.services;

import com.codeOfCritical.domain.Deviations;
import com.codeOfCritical.repositories.WebReport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeviationsServiceImpl implements DeviationsService {

    private WebReport productRepository;

    @Autowired
    public void setProductRepository(WebReport productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Integer listAllScenarios() {
        return Math.toIntExact(productRepository.count());
    }

    @Override
    public Deviations getDeviationsByScenarioName(String name) {
        return productRepository.findById(Integer.valueOf(name)).orElse(null);
    }

    @Override
    public Deviations saveDeviations(Deviations deviation) {
        return productRepository.save(deviation);
    }


}
