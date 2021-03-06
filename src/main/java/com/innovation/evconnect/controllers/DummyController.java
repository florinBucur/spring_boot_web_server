package com.innovation.evconnect.controllers;


import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.innovation.evconnect.bos.MessageBean;

@RestController
public class DummyController {
	
	@RequestMapping(method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, path = "/dummy")
	public ResponseEntity<MessageBean> dummyRun() {
		return new ResponseEntity<MessageBean>(new MessageBean("Test Dummy Endpoint"), HttpStatus.OK);
	}

}