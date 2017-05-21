package com.innovation.evconnect.controllers;


import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.innovation.evconnect.bos.LocationBean;
import com.innovation.evconnect.bos.MessageBean;
import com.innovation.evconnect.bos.RoomsBean;
import com.innovation.evconnect.entities.Rooms;
import com.innovation.evconnect.entities.Users;
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
		room.setDate(new Timestamp(System.currentTimeMillis()));
		try{
			roomsRepository.save(room);
		}catch (Exception e) {
			return new ResponseEntity<MessageBean>(new MessageBean(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<MessageBean>(new MessageBean(), HttpStatus.OK);
	}
	@GetMapping("/availableRooms")
	public List<RoomsBean> getAvailableRooms(){
		List<RoomsBean> result = new ArrayList<>();
		List<Rooms> entities = roomsRepository.availableRooms();
		for(Rooms room : entities){
			RoomsBean bean = new RoomsBean();
			bean.setAvailability(room.getAvailability());
			bean.setCapacity(room.getCapacity());
			bean.setFloor(room.getFloor());
			bean.setName(room.getName());
			bean.setSurface(room.getSurface());
			bean.setDate(room.getDate());
			result.add(bean);
		}
		return result;
	}
}
