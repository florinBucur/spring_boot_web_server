package com.innovation.evconnect.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.innovation.evconnect.bos.LocationBean;
import com.innovation.evconnect.bos.RoomsBean;
import com.innovation.evconnect.entities.Rooms;
import com.innovation.evconnect.entities.Users;
import com.innovation.evconnect.repo.RoomsRepository;
import com.innovation.evconnect.repo.UsersRepository;

@RestController
public class ClientController {
	
	@Autowired
	UsersRepository repository;
	
	@Autowired
	RoomsRepository roomsRepository;
	
	@RequestMapping("/locations")
	public List<LocationBean> getAllLocations(){
		Iterable<Users> all = repository.findAll();
		List<LocationBean> result = new ArrayList<>();
		for(Users entity : all){
			LocationBean bean = new LocationBean();
			bean.setName(entity.getLocation());
			result.add(bean);
		}
		return result;
	}
	
	@RequestMapping("/available")
	public List<RoomsBean> getAvailableLocations(@RequestParam("location") String location){
		Iterable<Rooms> all = roomsRepository.availableRooms();
		List<RoomsBean> result = new ArrayList<>();
		for(Rooms entity : all){
			RoomsBean bean = new RoomsBean();
			bean.setName(entity.getName());
			result.add(bean);
		}
		return result;
	}
}
