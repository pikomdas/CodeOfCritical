/*
 *   /////////////////// \\\\\\\\\\\\\\\\\\
 *   WWW.codeOfCritical.COM PRIVACY POLICY © 2012
 *   ListWithClassObject.java belongs to codeOfCritical
 *   Do not COPY or PASTE code to WEB from demoBDDFramework
 *   Creation date-time : 11/07/20, 12:43 AM
 *   Developer: partha.das
 *   /////////////////// \\\\\\\\\\\\\\\\\\
 */

package demo123;

import java.util.ArrayList;
import java.util.List;

public class ListWithClassObject
{
    public static void main(String[] args)
    {
        Container container = new Container("Romi", "Rain");
        System.out.println(container.ll);
    
        Container container1 = new Container("Mark", "Garix");
        System.out.println(container1.ll);
    }
    
}

class Container
{
    static List<Details> ll = new ArrayList<>();
    Details details;
    
    public Container(String firstName, String lastName)
    {
        details = new Details(firstName.length(), lastName.length());
        ll.add(details);
    }
    
}

class Details
{
    int lengthOfFirstName;
    int lengthOfLastName;
    
    public Details(int lengthOfFirstName, int lengthOfLastName)
    {
        this.lengthOfFirstName = lengthOfFirstName;
        this.lengthOfLastName = lengthOfLastName;
    }
    
    public int getLengthOfFirstName()
    {
        return lengthOfFirstName;
    }
    
    public int getLengthOfLastName()
    {
        return lengthOfLastName;
    }
    
    @Override
    public String toString()
    {
        return "Details{" +
                "lengthOfFirstName=" + lengthOfFirstName +
                ", lengthOfLastName=" + lengthOfLastName +
                '}';
    }
}