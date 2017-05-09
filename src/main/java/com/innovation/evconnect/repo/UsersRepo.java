package com.innovation.evconnect.repo;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.innovation.evconnect.entities.Orar;
import com.innovation.evconnect.entities.Users;

@Transactional
public interface UsersRepo extends JpaRepository<Orar, Long>{
	
	Users findByUsername(String username);
	
}
