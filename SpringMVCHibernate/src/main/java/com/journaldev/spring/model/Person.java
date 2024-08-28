package com.journaldev.spring.model;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Entity bean with JPA annotations
 * Hibernate provides JPA implementation
 * @author pankaj
 *
 */
@Entity
@Table(name="PERSON")
public class Person {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String name;
	
	private String country;
	
	private int age;
	
	@OneToMany(mappedBy = "person", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<StaffHasPerson> staffList;
	
	//@OneToMany(mappedBy = "person", cascade = CascadeType.ALL)
    //private Set<StaffHasPerson> staffHasPersons;

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

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public List<StaffHasPerson> getStaffList() {
		return staffList;
	}

	public void setStaffList(List<StaffHasPerson> staffList) {
		this.staffList = staffList;
	}

	/*public Set<StaffHasPerson> getStaffHasPersons() {
		return staffHasPersons;
	}

	public void setStaffHasPersons(Set<StaffHasPerson> staffHasPersons) {
		this.staffHasPersons = staffHasPersons;
	} */

	@Override
	public String toString(){
		return "id="+id+", name="+name+", country="+country+", age="+age;
	}
}
