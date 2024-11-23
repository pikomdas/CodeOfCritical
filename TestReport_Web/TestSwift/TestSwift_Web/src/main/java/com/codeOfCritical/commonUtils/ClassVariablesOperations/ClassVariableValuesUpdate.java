/*
 *  /////////////////// \\\\\\\\\\\\\\\\\\
 *  WWW.TECHMAHINDRA.COM PRIVACY POLICY © 2012
 * ClassVariableValuesUpdate.java belongs to AssetVantage
 *  Do not COPY or PASTE code to WEB from AV_QA_Framework
 * Creation date-time : 04/05/21, 12:32 AM
 * /////////////////// \\\\\\\\\\\\\\\\\\
 */

package com.codeOfCritical.commonUtils.ClassVariablesOperations;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.stream.Stream;

/**
 * @author partha.das
 */
public class ClassVariableValuesUpdate
{
    private final ClassOperationsAgent classOperations = new ClassOperations();

    /**
     * destination class
     */
    private final Class<?> toClass;

    /**
     * Destination class object reference
     */
//    private final Object toClass_;
    private final Object toClass_;
    // Map of the global variables and values of the source class
    private Map<String, Object> fromTheClassVariables;

    /**
     * This constructor call will pass the class's global variables values to destination class
     * Client will use this in builder pattern
     *
     * @param toClass   Destination class where class variables will get the values from Source class
     * @param toClass_  Object reference of the destination class
     * @param fromClass Source class , whose values will be transferred to Destination class
     */
    public ClassVariableValuesUpdate(Class<?> toClass, Object toClass_, Class<?> fromClass, Object sourceClass)
    {
        this.toClass = toClass;
        this.toClass_ = toClass_;
        try
        {
            this.fromTheClassVariables = classOperations
                    .getClassFields(fromClass)
                    .getClassFieldsNames()
                    .getClassFieldsValues(sourceClass)
                    .fieldsWithValuesMapper();
        }
        catch (IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e)
        {
            e.printStackTrace();
        }
    }

    /**
     * This method will assign the source class global variables values to
     * destination class
     */
    public void setValuesToTargetClass()
    {
        Stream.of(toClass.getDeclaredFields())
                .forEach(field -> {
                    field.setAccessible(true);
                    String variableName = field.getName();
                    if (fromTheClassVariables.containsKey(variableName))
                    {
                        try
                        {
                            field.set(toClass_, fromTheClassVariables.get(variableName));
                        }
                        catch (IllegalAccessException e)
                        {
                            e.printStackTrace();
                        }

                    }
                });

    }
}
