package com.innovation.evconnect.entities;


import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class Authorities implements Serializable{

	private static final long serialVersionUID = -8917019858420580659L;
	
	@EmbeddedId
	private AuthoritiesId id;

	public Authorities() {
		super();
	}

	public AuthoritiesId getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Authorities [id=" + id + "]";
	}

	public void setId(AuthoritiesId id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Authorities other = (Authorities) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	

}
