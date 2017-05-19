package com.innovation.evconnect.repo;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.innovation.evconnect.entities.Orar;
import com.innovation.evconnect.entities.Users;


@Repository
@Qualifier(value = "usersRepository")
public interface UsersRepository extends CrudRepository<Users, String> {

}
