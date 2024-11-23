/*
 *  /////////////////// \\\\\\\\\\\\\\\\\\
 *  WWW.TECHMAHINDRA.COM PRIVACY POLICY © 2012
 * ClassOperationsAgent.java belongs to AssetVantage
 *  Do not COPY or PASTE code to WEB from AV_QA_Framework
 * Creation date-time : 04/05/21, 1:01 AM
 * /////////////////// \\\\\\\\\\\\\\\\\\
 */

package com.codeOfCritical.commonUtils.ClassVariablesOperations;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * This interface methods will be used to do operation in Builder pattern's
 * inner static class. Mainly useful for Transaction page builder
 */
public interface ClassOperationsAgent
{
    ClassOperationsAgent getClassFields(Class<?> clazz);

    ClassOperationsAgent getClassFieldsNames();

    ClassOperationsAgent getClassFieldsValues(Object static_c) throws IllegalAccessException, InstantiationException,
            NoSuchMethodException, InvocationTargetException;

    Map<String, Object> fieldsWithValuesMapper();
}
