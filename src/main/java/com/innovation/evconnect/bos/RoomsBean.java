package com.innovation.evconnect.bos;

import java.sql.Timestamp;

public class RoomsBean {

	private long id;
	private int floor;
	private String capacity;
	private String surface;
	private String name;
	private String availability;
	private String owner;
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
		return "RoomsBean [id=" + id + ", floor=" + floor + ", capacity=" + capacity + ", surface=" + surface
				+ ", name=" + name + ", availability=" + availability + ", owner=" + owner + ", date=" + date + "]";
	}
}
