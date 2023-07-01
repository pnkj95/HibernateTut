package com.secondcache;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "myStudents")
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
public class Student5 {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private String city;
	
	private Certificate5 certi;
	
	public Student5() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student5(int id, String name, String city, Certificate5 certi) {
		super();
		this.id = id;
		this.name = name;
		this.city = city;
		this.certi = certi;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Certificate5 getCerti() {
		return certi;
	}

	public void setCerti(Certificate5 certi) {
		this.certi = certi;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", city=" + city + ", certi=" + certi + "]";
	}
	
	}
