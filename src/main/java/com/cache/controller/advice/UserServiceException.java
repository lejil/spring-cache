/**
 * 
 */
package com.cache.controller.advice;

/**
 * @author Lejil
 *
 */
public class UserServiceException extends RuntimeException {

	public UserServiceException(Long id) {
		super("User with ID " + id + " not found.");
	}

	/**
	 * @param message
	 */
	public UserServiceException(String message) {
		super(message);
	}

}
