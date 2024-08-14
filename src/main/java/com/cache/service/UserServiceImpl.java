/**
 * 
 */
package com.cache.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.cache.controller.advice.UserServiceException;
import com.cache.model.User;
import com.cache.repository.UserRepository;

/**
 * @author Lejil
 *
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	@Override
	@Cacheable(value = "user", key = "#id")
	public Optional<User> getUserById(Long id) {
		return Optional.ofNullable(userRepository.findById(id).orElseThrow(() -> new UserServiceException(id)));

	}

	@Override
	@CacheEvict(value = "user", key = "#id")
	public boolean deleteUser(Long id) {
		return userRepository.findById(id).map(usr -> {
			userRepository.delete(usr);
			return true;
		}).orElse(false);
	}

	@Override
	public User createUser(User user) {
		return userRepository.save(user);
	}

	@Override
	@CachePut(value = "user", key = "#id")
	public Optional<User> updateUser(Long id, User user) {
		return userRepository.findById(id).map(existingUser -> {
			existingUser.setEmail(user.getEmail());
			existingUser.setName(user.getName());
			return userRepository.save(existingUser);
		});
	}

}
