/**
 * 
 */
package com.cache.service;

import java.util.Optional;

import com.cache.model.User;

/**
 * @author Lejil
 *
 */
public interface UserService {

	/**
	 * 
	 * @param user
	 * @return
	 */
	User createUser(User user);

	/**
	 * 
	 * @param id
	 * @return
	 */
	Optional<User> getUserById(Long id);

	/**
	 * 
	 * @param id
	 * @return
	 */
	boolean deleteUser(Long id);

	/**
	 * @param id
	 * @param user
	 * @return
	 */
	Optional<User> updateUser(Long id, User user);

}
