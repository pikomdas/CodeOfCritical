/*
 *  /////////////////// \\\\\\\\\\\\\\\\\\
 *  WWW.TECHMAHINDRA.COM PRIVACY POLICY © 2012
 * ClassOperations.java belongs to AssetVantage
 *  Do not COPY or PASTE code to WEB from AV_QA_Framework
 * Creation date-time : 03/05/21, 10:23 PM
 * /////////////////// \\\\\\\\\\\\\\\\\\
 */

package com.codeOfCritical.commonUtils.ClassVariablesOperations;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Operations for the source class only
 *
 * @author partha.das
 */
public class ClassOperations implements ClassOperationsAgent
{
    public Class<?> clazz;
    private List<String> fieldsNames;
    private List<Field> fields;
    private List<Object> fieldValues;

    /**
     * This method will store the fields into an ArrayList
     *
     * @param clazz
     * @return
     */
    @Override
    public ClassOperations getClassFields(Class<?> clazz)
    {
        this.clazz = clazz;
        this.fields = Stream.of(clazz.getDeclaredFields()).collect(Collectors.toList());
        return this;
    }

    /**
     * This method will provide the Fields reference names only
     *
     * @return
     */
    @Override
    public ClassOperationsAgent getClassFieldsNames()
    {
        this.fieldsNames = this.fields
                .stream()
                .map(x -> x.getName())
                .collect(Collectors.toList());
        return this;
    }

    /**
     * This method will capture the fields' values of the source class
     *
     * @param static_c inner static class object reference
     * @return
     * @throws IllegalAccessException
     * @throws InstantiationException
     * @throws NoSuchMethodException
     * @throws InvocationTargetException
     */
    @Override
    public ClassOperationsAgent getClassFieldsValues(Object static_c) throws IllegalAccessException, InstantiationException,
            NoSuchMethodException, InvocationTargetException
    {
        this.fieldValues = this.fields
                .stream()
                .map(field -> {
                    Object x = null;
                    try
                    {
                        field.setAccessible(true);
                        // Getting values of the Builder class global variables
                        x = field.get(static_c);
                    }
                    catch (IllegalAccessException e)
                    {
                        e.printStackTrace();
                    }
                    return x;
                }).collect(Collectors.toList());
        return this;
    }

    /**
     * This method will return a Map of Class fields as Key and Field's values as Value
     *
     * @return source class's (Inner Static class) fields and values
     */
    @Override
    public Map<String, Object> fieldsWithValuesMapper()
    {
        Map<String, Object> fieldsWithValues = new HashMap<>();

        IntStream.range(0, fieldsNames.size())
                .forEach(i -> {
                    fieldsWithValues.put(fieldsNames.get(i), fieldValues.get(i));
                });
//        System.out.println(fieldsWithValues);
        return fieldsWithValues;
    }
}
