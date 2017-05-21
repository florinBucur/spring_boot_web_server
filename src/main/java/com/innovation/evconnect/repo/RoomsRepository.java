package com.innovation.evconnect.repo;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.innovation.evconnect.entities.Rooms;

@Repository
@Qualifier(value = "roomsRepository")
public interface RoomsRepository extends CrudRepository<Rooms, String>{

	@Query("select rs from Rooms rs where rs.id not in (select room.id from Reserved)")
	List<Rooms> availableRooms();
	
	@Query("select rs from Rooms rs where rs.owner = :username")
	List<Rooms> roomsByUser(@Param("username") String username);
	
}
