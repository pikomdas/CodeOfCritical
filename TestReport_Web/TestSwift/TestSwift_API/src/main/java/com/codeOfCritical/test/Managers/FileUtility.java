package com.codeOfCritical.test.Managers;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class FileUtility {
    public static void WriteResponseToFile(String data, String FileName) {
        File file = new File(".\\OutPutFiles\\" + FileName + ".txt");
        FileWriter fr = null;
        try {
            fr = new FileWriter(file);
            fr.write(data);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //close resources
            try {
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
