package com.innovation.evconnect.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "orar")
public class Orar implements Serializable{

	private static final long serialVersionUID = 1501684752686148251L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private long id;
	
	@Column(name="an")
	private Integer an;
	
	@Column(name="grupa")
	private String grupa;
	
	@Column(name="profesor")
	private String profesor;
	
	@Column(name="locatie")
	private String locatie;
	
	@Column(name="zi")
	private String zi;
	
	@Column(name="`ora_inceput`")
	private String oraInceput;
	
	@Column(name="`ora_sfarsit`")
	private String oraSfarsit;
	
	@Column(name="materie")
	private String materie;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Integer getAn() {
		return an;
	}

	public void setAn(Integer an) {
		this.an = an;
	}

	public String getGrupa() {
		return grupa;
	}

	public void setGrupa(String grupa) {
		this.grupa = grupa;
	}

	public String getProfesor() {
		return profesor;
	}

	public void setProfesor(String profesor) {
		this.profesor = profesor;
	}

	public String getLocatie() {
		return locatie;
	}

	public void setLocatie(String locatie) {
		this.locatie = locatie;
	}

	public String getZi() {
		return zi;
	}

	public void setZi(String zi) {
		this.zi = zi;
	}

	public String getOraInceput() {
		return oraInceput;
	}

	public void setOraInceput(String oraInceput) {
		this.oraInceput = oraInceput;
	}

	public String getOraSfarsit() {
		return oraSfarsit;
	}

	public void setOraSfarsit(String oraSfarsit) {
		this.oraSfarsit = oraSfarsit;
	}

	public String getMaterie() {
		return materie;
	}

	public void setMaterie(String materie) {
		this.materie = materie;
	}

	public Orar(Integer an, String grupa, String profesor, String locatie, String zi, String oraInceput,
			String oraSfarsit, String materie) {
		this.an = an;
		this.grupa = grupa;
		this.profesor = profesor;
		this.locatie = locatie;
		this.zi = zi;
		this.oraInceput = oraInceput;
		this.oraSfarsit = oraSfarsit;
		this.materie = materie;
	}
	
	protected Orar(){
		
	}

	@Override
	public String toString() {
		return "OrarTest [id=" + id + ", an=" + an + ", grupa=" + grupa + ", Profesor=" + profesor + ", locatie="
				+ locatie + ", zi=" + zi + ", oraInceput=" + oraInceput + ", oraSfarsit=" + oraSfarsit + ", materie="
				+ materie + "]";
	}
}
