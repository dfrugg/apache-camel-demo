/**
 * 
 */
package cjug.demo.camel.services;

/**
 * Provides a bean to integrate with.
 * 
 * @author dfr2
 */
public interface MyService {
	
	/**
	 * Gets the current time in a message.
	 * @return
	 */
	String getTime();
}
