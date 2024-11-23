package com.codeOfCritical.commonUtils;

import io.cucumber.datatable.DataTable;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Generic {
    private FileHandling fileHandling = null;
//    private String filePath = "D:\\AM_FM\\autofw\\TemenosT24\\TemenosT24_Web\\src\\main\\java\\com\\temenos\\TestData\\TestData.xlsx";

    public Generic() throws IOException {

//        this.fileHandling = new FileHandling(filePath);
    }

    public Map<String, String> FetchData(DataTable datatable) throws IOException {
        List<Map<String, String>> list = datatable.asMaps(String.class, String.class);
        String identifier = list.get(0).get("Identifier");
        String fname = list.get(0).get("FileName");
        System.out.println("Identifier == " + identifier);
        System.out.println("File Name == " + fname);
        // Fetch Test Data into Map
        Map<String, String> TestDataMap;
        fileHandling = new FileHandling(fname);
        TestDataMap = fileHandling.GetTestData(identifier);
//        System.out.println("User Name Is = " + TestDataMap.get("SignUpFirstName"));

        return TestDataMap;
    }


}
