package com.innovation.evconnect.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.innovation.evconnect.bos.OrarBO;
import com.innovation.evconnect.bos.UsersBO;
import com.innovation.evconnect.entities.Orar;
import com.innovation.evconnect.entities.Users;
import com.innovation.evconnect.repo.OrarTestRepo;
import com.innovation.evconnect.repo.UsersRepo;

@RestController
@RequestMapping("/users")
public class UsersController {
	
	@Autowired
	UsersRepo userRepository;
	
	@RequestMapping("/getUser")
	public UsersBO getUser(@RequestParam(name="username") String username){
		Users user = userRepository.findByUsername(username);
		UsersBO userBo = new UsersBO(user.getUserID(), user.getUsername(), user.getPassword(), user.getUserRole());
		return userBo;
	}

	
}
