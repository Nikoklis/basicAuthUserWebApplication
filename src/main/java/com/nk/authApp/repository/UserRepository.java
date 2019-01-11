package com.nk.authApp.repository;

import org.springframework.data.repository.CrudRepository;

import com.nk.authApp.model.User;

public interface UserRepository extends CrudRepository<User, Integer> {
	
	@SuppressWarnings("unchecked")
	User save(User user);
	
	User findUserByEmailAndPassword(String email,String password);
	
	User findUserByEmail(String email);
	
	User findUserById(Integer id);
}
