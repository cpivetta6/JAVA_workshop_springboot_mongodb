package com.caiopivetta6.workshopmongo.domain;

import java.time.Instant;
import java.util.Objects;

public class Comment {

	private String id;
	private String text;
	private Instant date;
	
	public Comment() {
		
	}

	public Comment(String id, String text, Instant date) {
		super();
		this.id = id;
		this.text = text;
		this.date = date;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Comment other = (Comment) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
}
