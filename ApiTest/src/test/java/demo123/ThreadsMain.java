/**
 * /////////////////// \\\\\\\\\\\\\\\\\\
 * WWW.codeOfCritical.COM PRIVACY POLICY © 2012
 * ThreadsMain.java belongs to codeOfCritical
 * Do not COPY or PASTE code to WEB from demoBDDFramework
 * Creation date-time : 12-May-2020 - 4:41:36 pm
 * /////////////////// \\\\\\\\\\\\\\\\\\
 * Author is : partha.das
 */

/**
 *
 */
package demo123;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author partha.das
 *
 */
public class ThreadsMain
{
    @Test
    public void main() throws InterruptedException
    {
        List<String> demo = List.of("Artificial", "IntelligenceBI", "and", "VisualizationBig", "DataBlockchainCloud", "ComputingCyber"
                , "SecurityData", "ScienceData", "Warehousing", "and", "ETLDatabasesDevOpsDigital", "MarketingFront", "End", "Web", "DevelopmentMobile", "DevelopmentOperating"
                , "SystemsProject", "Management", "and", "MethodologiesRobotic", "Process", "AutomationSoftware", "TestingSystems", "Test", "Architecture");
        List<Integer> numbers = new ArrayList<>();
        for (String s : demo)
        {
            numbers.add(s.length());
        }
        Ignite ig = new Ignite();
        List<Integer> output=new ArrayList<>();
        numbers.stream()
                .parallel()
                .forEach(x -> {
                   if( ig.addResult(x)){
                       output.add(1);
                   }
                   else{
                       
                       output.add(0);
                   }
                });
        System.out.println("======================");
        System.out.println(Ignite.ll);
        System.out.println("======================");
        System.out.println(output);
    }
}

class Ignite
{
    public static List<Boolean> ll = new ArrayList<Boolean>();
    int count =0;
    private boolean checkList(int x) throws InterruptedException
    {
        if (x % 2 == 0)
        {
            if(x>10 && count<100){
                Thread.sleep(100);
                count++;
                checkList(x);
            }
            count=0;
            System.out.println("found "+x+" "+Thread.currentThread().getName());
            return true;
        } else
        {
            count=0;
           return false;
        }
    }
    
    public boolean addResult(int x){
        try
        {
            if(checkList(x)){
                ll.add(true);
                return true;
            }
            else{
                ll.add(false);
                return false;
            }
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
            return false;
        }
    }
}