package com.innovation.evconnect.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.innovation.evconnect.entities.Test;

public interface TestRepo extends CrudRepository<Test, Long> {
	List<Test> findByName(String name);
}
