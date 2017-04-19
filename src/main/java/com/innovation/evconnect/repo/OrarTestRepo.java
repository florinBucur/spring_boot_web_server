package com.innovation.evconnect.repo;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.innovation.evconnect.entities.Orar;

@Transactional
public interface OrarTestRepo extends JpaRepository<Orar, Long>{
	List<Orar> findByGrupa(String grupa);
	List<Orar> findByGrupaAndZi(String grupa, String zi);
	
	@Query("select i from Orar i where LOWER(i.grupa) LIKE CONCAT('%',:grp,'%') and LOWER(i.zi) = :zi and i.an = :an")
	List<Orar> filterByGrupaZiAn(@Param("grp") String grupa, @Param("zi") String zi, @Param("an") int an);
}
