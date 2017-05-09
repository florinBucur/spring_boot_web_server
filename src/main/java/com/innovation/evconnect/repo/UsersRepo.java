package com.innovation.evconnect.repo;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.innovation.evconnect.entities.Users;

@Transactional
public interface UsersRepo extends JpaRepository<Users, Long>{
	
	Users findByUsername(String username);
	List<Users> findAll(); 
}
