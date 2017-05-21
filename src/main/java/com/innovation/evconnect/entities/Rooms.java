package com.innovation.evconnect.entities;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "rooms")
public class Rooms implements Serializable{
	
	private static final long serialVersionUID = -8133012012986851604L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name="floor")
	private int floor;
	
	@Column(name="capacity")
	private String capacity;
	
	@Column(name="surface")
	private String surface;
	
	@Column(name="name")
	private String name;
	
	@Column(name="availability")
	private String availability;
	
	@Column(name="owner")
	private String owner;
	
	@Column(name="date")
	private Timestamp date;
	
	public Timestamp getDate() {
		return date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getFloor() {
		return floor;
	}

	public void setFloor(int floor) {
		this.floor = floor;
	}

	public String getCapacity() {
		return capacity;
	}

	public void setCapacity(String capacity) {
		this.capacity = capacity;
	}

	public String getSurface() {
		return surface;
	}

	public void setSurface(String surface) {
		this.surface = surface;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAvailability() {
		return availability;
	}

	public void setAvailability(String availability) {
		this.availability = availability;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	@Override
	public String toString() {
		return "Rooms [id=" + id + ", floor=" + floor + ", capacity=" + capacity + ", surface=" + surface + ", name="
				+ name + ", availability=" + availability + ", owner=" + owner + ", date=" + date + "]";
	}

	
}
