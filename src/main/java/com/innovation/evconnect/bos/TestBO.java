package com.innovation.evconnect.bos;

public class TestBO {
	private final long id;
	private final String name;
	
	public TestBO(long id, String name) {
		this.id = id;
		this.name = name;
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}
}
