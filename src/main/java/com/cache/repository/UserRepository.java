/**
 * 
 */
package com.cache.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
import org.springframework.stereotype.Repository;

import com.cache.model.User;


@Repository
public interface UserRepository extends JpaRepository<User, Long>  {

}
