package com.innovation.evconnect.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
		user.setEnabled(Boolean.TRUE);
		System.out.println(user);
		Authorities authority = new Authorities();
		authority.setId(new AuthoritiesId(user.getUserName(), userBean.getRole()));
		List<Authorities> auths = new ArrayList<>();
		auths.add(authority);
		user.setAuthorities(auths);
		userRepository.save(user);
		return new ResponseEntity<MessageBean>(new MessageBean("User Created !!!"), HttpStatus.OK);
	}

}
