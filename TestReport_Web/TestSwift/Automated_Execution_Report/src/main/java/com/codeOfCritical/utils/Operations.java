/*
 *  /////////////////// \\\\\\\\\\\\\\\\\\
 *  WWW.codeOfCritical.COM PRIVACY POLICY © 2012
 * Operations.java belongs to codeOfCritical
 *  Do not COPY or PASTE code to WEB from ApiTest
 * Creation date-time : 01/02/21, 9:28 PM
 * /////////////////// \\\\\\\\\\\\\\\\\\
 */

package com.codeOfCritical.utils;

public class Operations
{
    /**
     * @param x    integer array
     * @param desc if true then desc else asc
     * @return integer array
     */
    public int[] sortInteger(int[] x, boolean desc)
    {
        if (desc)
        {
            int i = 0;
            int j = 0;
            while (i < x.length)
            {
                while (j < x.length)
                {
                    if (x[i] > x[j])
                    {
                        int b = x[i];
                        x[i] = x[j];
                        x[j] = b;

                    }
                    j++;
                }
                i++;
            }
        }
        else
        {
            for (int i = 0; i < x.length; i++)
            {
                for (int j = i + 1; j < x.length; j++)
                {
                    if (x[i] < x[j])
                    {
                        int b = x[i];
                        x[i] = x[j];
                        x[j] = b;

                    }
                }
            }
        }
        return x;
    }

    /**
     * @param x
     * @return
     */
    public int[] findMaxMin(int[] x)
    {
        int[] intArr = new int[2];
        int i = 1;
        int max = x[0];
        int min = 0;
        while (i < x.length)
        {
            if (x[i] > max)
            {
                max = x[i];
            }
            else
            {
                if (x[i] < min)
                {
                    min = x[i];
                }
            }
            i++;
        }
        intArr[0] = max;
        intArr[1] = min;
        return intArr;
    }

    public int nthHighestElement(int[] x)
    {
        sortInteger(x, true);
        return x[0];
    }

    public int nthSmallestElement(int[] x)
    {
        sortInteger(x, false);
        return x[0];
    }

    /**
     * Sorting a string array
     *
     * @param arr
     * @return
     */
    public String[] sortString(String[] arr)
    {
        for (int i = 0; i < arr.length; i++)
        {
            for (int j = i + 1; j < arr.length; j++)
            {
                if (arr[i].compareTo(arr[j]) > 0)
                {
                    String temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }

            }

        }
        return arr;
    }


}
