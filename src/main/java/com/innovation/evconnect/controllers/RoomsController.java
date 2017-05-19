package com.innovation.evconnect.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.innovation.evconnect.bos.MessageBean;
import com.innovation.evconnect.bos.RoomsBean;
import com.innovation.evconnect.bos.UserBean;
import com.innovation.evconnect.entities.Rooms;
import com.innovation.evconnect.repo.RoomsRepository;
import com.innovation.evconnect.repo.UsersRepository;
import com.innovation.evconnect.utils.AuthUsers;


@RestController
public class RoomsController {

	@Autowired
	UsersRepository repository;
	
	@Autowired
	RoomsRepository roomsRepository;
	
	@PostMapping(value = "/createRoom")
	public ResponseEntity<MessageBean> createRoom(@RequestBody RoomsBean roomB){
		Rooms room = new Rooms();
		AuthUsers authU = new AuthUsers();
		room.setOwner(authU.getLoggedUsername());
		room.setAvailability(roomB.getAvailability());
		room.setCapacity(roomB.getCapacity());
		room.setFloor(roomB.getFloor());
		room.setName(roomB.getName());
		room.setSurface(roomB.getSurface());
		
		
		roomsRepository.save(room);
		return new ResponseEntity<MessageBean>(new MessageBean(), HttpStatus.OK);
	}
	
	
}
