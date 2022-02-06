package org.codeOfCritical.api.api.utils;

/**
 * This interface will be used to trigger
 * 
 * @author partha.das
 *
 */
@FunctionalInterface
public interface RestAdapter
{

	<T> T execute(Class<T> responseClass);
}
