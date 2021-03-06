package com.innovation.evconnect.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.innovation.evconnect.bos.MessageBean;
import com.innovation.evconnect.bos.UserBean;
import com.innovation.evconnect.entities.Authorities;
import com.innovation.evconnect.entities.AuthoritiesId;
import com.innovation.evconnect.entities.Users;
import com.innovation.evconnect.repo.UsersRepository;


@RestController
public class SignupController {

	@Autowired
	private UsersRepository userRepository;

	@PostMapping(value = "/signup")
	public ResponseEntity<MessageBean> signup(@RequestBody UserBean userBean) {
		Users user = new Users();
		user.setUserName(userBean.getEmail());
		user.setPassword(userBean.getPassword());
		user.setLocation(userBean.getLocation());
		user.setEnabled(Boolean.TRUE);
		System.out.println(user);
		Authorities authority = new Authorities();
		authority.setId(new AuthoritiesId(user.getUserName(), userBean.getRole()));
		List<Authorities> auths = new ArrayList<>();
		auths.add(authority);
		user.setAuthorities(auths);
		try{
			userRepository.save(user);
		}catch(Exception e){
			return new ResponseEntity<MessageBean>(new MessageBean(), HttpStatus.OK);
		}
		
		return new ResponseEntity<MessageBean>(new MessageBean(), HttpStatus.OK);
//		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PostMapping(value = "/logg")
	public ResponseEntity<String> logg(@RequestBody UserBean username) {
		Iterable<Users> users = userRepository.findAll();
		String usr = username.getEmail().trim();
		String res = "";
		List<Authorities> result = null;
		for(Users u : users){
			if(u.getUserName().trim().contentEquals(usr)){
				 result = u.getAuthorities();
				 if(result.toString().toLowerCase().contains("admin"))
					res = "admin";
				 else 
					 res = "client";
		}
		}
		Gson g = new Gson();
		
		return new ResponseEntity<>(g.toJson(res),HttpStatus.OK);
	}
	
}
