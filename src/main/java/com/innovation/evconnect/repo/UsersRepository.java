package com.innovation.evconnect.repo;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.innovation.evconnect.entities.Users;


@Repository
@Qualifier(value = "usersRepository")
public interface UsersRepository extends CrudRepository<Users, String> {

}
