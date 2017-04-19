package com.innovation.evconnect.bos;

public class OrarBO {
	
	private long id;
	
	private Integer an;
	
	private String grupa;
	
	private String Profesor;
	
	private String locatie;
	
	private String zi;
	
	private String oraInceput;
	
	private String oraSfarsit;
	
	private String materie;

	public OrarBO(long id, Integer an, String grupa, String profesor, String locatie, String zi, String oraInceput,
			String oraSfarsit, String materie) {
		super();
		this.id = id;
		this.an = an;
		this.grupa = grupa;
		Profesor = profesor;
		this.locatie = locatie;
		this.zi = zi;
		this.oraInceput = oraInceput;
		this.oraSfarsit = oraSfarsit;
		this.materie = materie;
	}

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
		return Profesor;
	}

	public void setProfesor(String profesor) {
		Profesor = profesor;
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

	@Override
	public String toString() {
		return "Orar [id=" + id + ", an=" + an + ", grupa=" + grupa + ", Profesor=" + Profesor + ", locatie=" + locatie
				+ ", zi=" + zi + ", oraInceput=" + oraInceput + ", oraSfarsit=" + oraSfarsit + ", materie=" + materie
				+ "]";
	}
}
