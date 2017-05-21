package com.innovation.evconnect.controllers;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.innovation.evconnect.bos.OrarBO;
import com.innovation.evconnect.entities.Orar;
import com.innovation.evconnect.repo.OrarTestRepo;


@RestController
public class OrarController {

	@Autowired
	OrarTestRepo repository;

	@RequestMapping("/orar")
	public List<OrarBO> getByGrupaAndZi(@RequestParam(name="grupa") String grupa, 
			@RequestParam(name="zi") String zi){
		Iterable<Orar> all = repository.findByGrupaAndZi(grupa, zi);
		List<OrarBO> result = new ArrayList<>();
		for(Orar entity : all){
			OrarBO bean = new OrarBO(entity.getId(), entity.getAn(),entity.getGrupa(),
					entity.getProfesor(), entity.getLocatie(), entity.getZi(), 
					entity.getOraInceput(), entity.getOraSfarsit(), entity.getMaterie());
			result.add(bean);
		}
		return result;
	}

	@RequestMapping("/orar/like")
	public List<OrarBO> getByGrupaLike(@RequestParam(name="grupa") String grupa, 
			@RequestParam(name="zi") String zi){

		String parity = getParity();
		int an = 0;
		String[] tokens = grupa.split(" ");
		for(String str : tokens){
			if(isNumeric(str)){
				an = Character.getNumericValue(str.charAt(1));
			}
		}
		System.out.println(an);
		Iterable<Orar> all = repository.filterByGrupaZiAn(grupa.toLowerCase(), zi.toLowerCase(), an);
		List<OrarBO> result = new ArrayList<>();
		for(Orar entity : all){
			if(entity.getMaterie().contains(parity) || 
					(!entity.getMaterie().contains("(P)") && !entity.getMaterie().contains("(I)"))){
				OrarBO bean = new OrarBO(entity.getId(), entity.getAn(),entity.getGrupa(),
						entity.getProfesor(), entity.getLocatie(), entity.getZi(), 
						entity.getOraInceput(), entity.getOraSfarsit(), entity.getMaterie());
				result.add(bean);
			}
		}
		return result;
	}

	/**
	 * 
	 * @return "(P)" - even, "(I)" - odd
	 */
	public String getParity(){
		LocalDate startDate = LocalDate.of(2017, Month.FEBRUARY, 20);
		LocalDateTime time = LocalDateTime.now();
		long weeks = ChronoUnit.WEEKS.between(startDate, time);

		if( weeks % 2 == 0){
			return "(P)";
		}else{
			return "I";
		}
	}
	
	public static boolean isNumeric(String str)  
	{  
	  try  
	  {  
	    Double.parseDouble(str);  
	  }  
	  catch(NumberFormatException nfe)  
	  {  
	    return false;  
	  }  
	  return true;  
	}

}
