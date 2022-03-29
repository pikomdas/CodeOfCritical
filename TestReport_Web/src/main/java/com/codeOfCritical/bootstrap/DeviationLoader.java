package com.codeOfCritical.bootstrap;

import com.codeOfCritical.data.ReadData;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DeviationLoader implements ApplicationListener<ContextRefreshedEvent> {
    @Autowired
    public ReadData readData;

//    private WebReport deviationsRepository;

    private Logger log = LogManager.getLogger(DeviationLoader.class);

//    @Autowired
//    public void setDeviationRepository(WebReport deviationsRepository) {
//        this.deviationsRepository = deviationsRepository;
//    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        readData.readJSON();
    }
}