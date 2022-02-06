/*
 *   /////////////////// \\\\\\\\\\\\\\\\\\
 *   WWW.codeOfCritical.COM PRIVACY POLICY © 2012
 *   Listener.java belongs to codeOfCritical
 *   Do not COPY or PASTE code to WEB from demoBDDFramework
 *   Creation date-time : 18/06/20, 1:55 PM
 *   Developer: partha.das
 *   /////////////////// \\\\\\\\\\\\\\\\\\
 */

package FunctionalInterfaces;

@FunctionalInterface
public interface Listener<S,T>
{
    S act(T t);
    
    default T completed(T t){
        return (T) act(t);
    }
}
