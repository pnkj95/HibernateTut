package com.many2many.mapping;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Employee {

	@Id
	private int eid;
	private String employeeName;
	
	//Using fetchtype = EAGER will also fetch the data of child table at the time of fetching parent table data, else LAZY will query database only, when we try to get any data of child table
	//By default, fetch type is LAZY
	@ManyToMany(fetch = FetchType.EAGER)
	//@JoinTable used to change the name of Join table
	@JoinTable(name = "emp_proj",joinColumns = {
			@JoinColumn(name = "eid")},
			inverseJoinColumns = {
			@JoinColumn(name = "pid")		
	})
	private List<Project> projects;

	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

	public Employee(int eid, String employeeName, List<Project> projects) {
		super();
		this.eid = eid;
		this.employeeName = employeeName;
		this.projects = projects;
	}

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	} 
	
	
	
}
