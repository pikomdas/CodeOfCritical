package com.codeOfCritical.commonUtils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;


public class FileHandling {

    private static final Logger log = LogManager.getLogger(FileHandling.class.getName());

    private ThreadLocal<XSSFWorkbook> wb = new ThreadLocal<>();

    public FileHandling(String FileName1) throws IOException {
        FileInputStream fis = new FileInputStream(FileName1);
        this.wb.set(new XSSFWorkbook(fis));
    }

    public Map<String, String> GetTestData(String Identifier1) throws IOException {
        XSSFSheet sh = wb.get().getSheet("sheet1");

        int LastRow = sh.getLastRowNum();
        int LastCol = sh.getRow(0).getLastCellNum();

        Row row = sh.getRow(0);
        Cell cell = row.getCell(0);

        Map<String, String> TestData = new HashMap<String, String>();

        boolean flag = false;

        for (int i = 0; i <= LastRow; i++) {
            String xx = sh.getRow(i).getCell(0).getStringCellValue();
            if (xx.equals(Identifier1)) {
                for (int j = 0; j < LastCol; j++) {
                    String key1 = sh.getRow(0).getCell(j).getStringCellValue();
                    String value1 = sh.getRow(i).getCell(j).getStringCellValue();

                    TestData.put(key1, value1);
                    flag = true;
                    //return TestData;
                }
            }
        }

        if (flag == false) {
            log.info("The Identifier is Not Available in Test Data Excel");
            return null;
        }
        return TestData;

    }

    public int getRandomNumberUsingNextInt(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min) + min;
    }

}