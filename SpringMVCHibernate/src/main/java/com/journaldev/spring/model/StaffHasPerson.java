package com.journaldev.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Entity bean with JPA annotations
 * Hibernate provides JPA implementation
 * @author pankaj
 *
 */
@Entity
@Table(name="staff_has_person")
public class StaffHasPerson {
	
	@Id
	@Column(name="staff_has_person_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int staff_has_person_id;
	
	@ManyToOne
    @JoinColumn(name = "staff_id", nullable = false)
    private Staff staff;

    @ManyToOne
    @JoinColumn(name = "person_id", nullable = false)
    private Person person;
    
    public StaffHasPerson() {}

    public StaffHasPerson(Staff staff, Person person) {
        this.staff = staff;
        this.person = person;
    }

	public int getStaff_has_person_id() {
		return staff_has_person_id;
	}

	public void setStaff_has_person_id(int staff_has_person_id) {
		this.staff_has_person_id = staff_has_person_id;
	}

	public Staff getStaff() {
		return staff;
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}
    
	@Override
	public String toString(){
		return "id="+staff_has_person_id+", Staff ID="+staff+", Person ID="+person;
	}
    
	
}