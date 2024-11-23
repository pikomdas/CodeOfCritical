package com.codeOfCritical.commonUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class cleanStringFormat
{

    public cleanStringFormat()
    {

    }

    @Deprecated
    public static double rmvdtFmtctd_backup(String text)
    {
        boolean nullCheck = text.trim().isEmpty();
        if (nullCheck == false)
        {
            char[] in = text.toCharArray();
            List<Character> c = new ArrayList<Character>();
            for (char nn : in)
            {
                c.add(nn);
            }
            int spaceBetweenBrackets = c.indexOf(')') - c.indexOf('(');
            String s1 = text.substring(0, text.length() - spaceBetweenBrackets - 1).replaceAll(",", "").trim();
            return convertTheStringTodouble(s1);
        } else if (nullCheck)
        {
            return 0.00;
        }
        return 0.00;
    }

    public static double rmvdtFmtctd(String text)
    {
        if (text != null && !text.isEmpty())
        {
            char[] container = text.toCharArray();
            StringBuilder removedCommaAndBrackets = new StringBuilder();
            for (char c : container)
            {
                if (c == '(')
                {
                    break;
                } else if (text.trim().equals("-"))
                {
                    String sa = text.replace("-", "0");
                    return convertTheStringTodouble(sa);
                } else if (c == ',')
                {

                } else
                {
                    removedCommaAndBrackets.append(c);
                }
            }
            return convertTheStringTodouble(removedCommaAndBrackets.toString());

        } else
        {
            return 0.00;
        }
    }

    public static double rmPercentage(String text)
    {
        if (text != null && !text.isEmpty())
        {
            //removing text inside brackets , PME benchMark TWR
            text = text.split("\n")[0].trim();

            if (text.trim().equals("-"))
            {
                String sa = text.replace("-", "0");
                return convertTheStringTodouble(sa);
            } else if (text.trim().matches("[A-Za-z]+"))
            { // removing nan NA
                return 0;
            } else
            {
                String step1 = text.trim().replaceAll("[,%,*]", "");
                return convertTheStringTodouble(step1);
            }
        }
        return 0;

    }

    public static double rmcComma(String text)
    {
        boolean nullCheck = text.trim().isEmpty();
        if (!nullCheck)
        {
            String step1 = text.trim().replaceAll(",", "");
            return convertTheStringTodouble(step1);
        }
        return 0;

    }

    @Deprecated
    public static double rmvdtFmtctd_backup_1(String text)
    {
        // boolean nullCheck = StringUtils.isEmpty(text.trim());
        // if (nullCheck == false)
        if (text != null && !text.isEmpty())
        {
            if (text.contains("Jan") || text.contains("Feb") || text.contains("Apr") || text.contains("Mar")
                    || text.contains("May") || text.contains("Jun") || text.contains("Jul") || text.contains("Aug")
                    || text.contains("Sep") || text.contains("Oct") || text.contains("Nov") || text.contains("Dec"))
            {
                // replacing "," from string
                String step1 = text.replaceAll(",", "");
                String dateFormat = "(xx-xxx-xxxx)";
                String step2 = step1.substring(0, (step1.length() - dateFormat.length()));
                // double purchaseValue = Double.parseDouble(step2);
                return convertTheStringTodouble(step2);
            } else
            {
                String step1 = text.replaceAll(",", "");
                // double purchaseValue = Double.parseDouble(step1);
                return convertTheStringTodouble(step1);
            }
        } else
        {
            return 0.00;
        }
    }

    private static double convertTheStringTodouble(String input)
    {
        if (!input.isEmpty())
        {
            Function<String, Double> cnvt = str -> Double.parseDouble(str);
            return cnvt.apply(input);
        } else
        {
            return 0.00;
        }
    }
}
