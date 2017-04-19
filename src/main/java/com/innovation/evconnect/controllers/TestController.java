package com.innovation.evconnect.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.innovation.evconnect.bos.TestBO;
import com.innovation.evconnect.entities.Test;
import com.innovation.evconnect.repo.TestRepo;

@RestController
public class TestController {

	private final AtomicLong counter = new AtomicLong();
    private static final String template = "Hello plm, %s!";
    
    @Autowired
    TestRepo repository;
	
	@RequestMapping("/test")
	public TestBO greeting(@RequestParam(value="name", defaultValue="World") String name) {
		return new TestBO(counter.incrementAndGet(),
				String.format(template, name));
	}
	
	@RequestMapping("/save")
	public String save(@RequestParam(value="name", defaultValue="World") String name) {
		repository.save(new Test( name));
		return "Done";
	}
	
	@RequestMapping("/getAll")
	public List<TestBO> getAll(){
		
		Iterable<Test> all = repository.findAll();
		List<TestBO> result = new ArrayList<>();
		for(Test entity : all){
			TestBO bean = new TestBO(entity.getId(), entity.getName());
			result.add(bean);
		}
		return result;
	}
	
}


