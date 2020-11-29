/*
 *   /////////////////// \\\\\\\\\\\\\\\\\\
 *   WWW.ASSETVANTAGE.COM PRIVACY POLICY © 2012
 *   FileWriting_mt.java belongs to AssetVantage
 *   Do not COPY or PASTE code to WEB from demoBDDFramework
 *   Creation date-time : 24/06/20, 2:50 PM
 *   Developer: partha.das
 *   /////////////////// \\\\\\\\\\\\\\\\\\
 */

package FileCreation;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FileWriting_mt
{
    
    public static volatile List<String> ll = Collections.synchronizedList(new ArrayList<>());
    
    public static void main(String[] args)
    {
        
        
        Runnable r = () -> {
            String s = "Partha ";
            ll.add(s);
            TestCase1 m = new TestCase1();
            m.writeTOFile(ll);
        };
        
        IntStream.range(0, 20)
                //.parallel()
                .forEach(x -> {
                    System.out.println("Thread " + Thread.currentThread().getName());
                    new Thread(r).start();
                    
                });
        
    }
    
}

class TestCase1
{
    public void writeTOFile(List<String> text1)
    {
        String text = text1.stream().collect(Collectors.joining());
        System.out.println(Thread.currentThread().getName() + " --- " + text);
        try
        {
            File file = new File("D:\\EclipseWorkspace\\ApiTest\\src\\test\\java\\FileCreation\\ThreadTest.txt");
            if (file.exists())
            {
                file.delete();
            }
            file.createNewFile();
            OutputStream outputStream = new FileOutputStream(file);
            Writer writer = new OutputStreamWriter(outputStream);
            writer.write(text);
            writer.write(text1.size());
            writer.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
