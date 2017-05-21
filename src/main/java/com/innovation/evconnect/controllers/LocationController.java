package com.innovation.evconnect.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.innovation.evconnect.bos.LocationBean;
import com.innovation.evconnect.entities.Authorities;
import com.innovation.evconnect.entities.Users;
import com.innovation.evconnect.repo.UsersRepository;

@RestController
public class LocationController {
	@Autowired
	private UsersRepository userRepository;

	@GetMapping("/allLocations")
	public ResponseEntity<List<LocationBean>> getLocation(){
		
		List<LocationBean> jsonResponse = new ArrayList<>();
		Iterable<Users> users = userRepository.findAll();
		List<Authorities> result = null;
		for(Users u : users){
			result = u.getAuthorities();
			if(result.toString().toLowerCase().contains("admin")){
				LocationBean json = new LocationBean();
				json.setName(u.getLocation());
				jsonResponse.add(json);
			}
				
		}
		
		return new ResponseEntity<List<LocationBean>>(jsonResponse,HttpStatus.OK);
	}

}
