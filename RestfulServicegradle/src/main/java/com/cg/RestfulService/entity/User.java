package com.cg.RestfulService.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class User {

	@Id
	private Integer id;
	@Column(name="name")
	private String name;
	@Temporal(value=TemporalType.DATE)
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date birthDate;

	public User() {
		System.out.println("User object created using default constructor");
	}

	public User(Integer id, String name, Date birthDate) {
		System.out.println("User object created using parameterized constructor");
		this.id = id;
		this.name = name;
		this.birthDate = birthDate;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", birthDate=" + birthDate + "]";
	}

}
