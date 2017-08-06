package com.monideepde.resourceLocator.data.entity;

import javax.persistence.*;

@Entity
@Table(name="LOCATION")
public class Location {
	@Id
	@Column(name="LOC_ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	@Column(name="NAME")
	private String name;
	@Column(name="CITY")
	private String cityName;
	
	public Location(String name, String cityName) {
		super();
		this.name = name;
		this.cityName = cityName;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
}
