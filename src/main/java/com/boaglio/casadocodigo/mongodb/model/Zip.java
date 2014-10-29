package com.boaglio.casadocodigo.mongodb.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "zipcodes")
public class Zip {

	@Id
	private ObjectId id;

	private String city;

	private String state;

	private Loc loc;

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Loc getLoc() {
		return loc;
	}

	public void setLoc(Loc loc) {
		this.loc = loc;
	}

	@Override
	public String toString() {
		return "Zip [id=" + id + ", city=" + city + ", state=" + state + ", loc=" + loc + "]";
	}

}
