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
@Table(name="Staff")
public class Staff {
	
	@Id
	@Column(name="staff_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int staff_id;
	
	private String staff_name;
	
	@OneToMany(mappedBy = "staff", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<StaffHasPerson> personList;
	
	//@OneToMany(mappedBy = "staff", cascade = CascadeType.ALL)
	//private Set<StaffHasPerson> staffHasPersons;

	public int getStaff_id() {
		return staff_id;
	}

	public void setStaff_id(int staff_id) {
		this.staff_id = staff_id;
	}

	public String getStaff_name() {
		return staff_name;
	}

	public void setStaff_name(String staff_name) {
		this.staff_name = staff_name;
	}
	
	/*public Set<StaffHasPerson> getStaffHasPersons() {
		return staffHasPersons;
	}

	public void setStaffHasPersons(Set<StaffHasPerson> staffHasPersons) {
		this.staffHasPersons = staffHasPersons;
	} */

	/**
	 * @return the personList
	 */
	public List<StaffHasPerson> getPersonList() {
		return personList;
	}

	/**
	 * @param personList the personList to set
	 */
	public void setPersonList(List<StaffHasPerson> personList) {
		this.personList = personList;
	}

	@Override
	public String toString(){
		return "id="+staff_id+", name="+staff_name;
	}
	
}