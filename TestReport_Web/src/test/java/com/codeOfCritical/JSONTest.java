package com.codeOfCritical;

import com.codeOfCritical.configuration.AppConfig;
import com.codeOfCritical.data.ReadData;
import org.json.simple.parser.ParseException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;

public class JSONTest {

    public static void main(String[] args) throws IOException, ParseException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        ReadData rd = context.getBean("readdata", ReadData.class);
        System.out.println(rd.readJSON().listOfAllScenarios());
        context.close();
        //System.out.println(new ReadData().readJSON().listAllScenarios());
    }
}
