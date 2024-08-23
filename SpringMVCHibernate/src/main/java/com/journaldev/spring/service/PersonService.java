package com.journaldev.spring.service;

import java.util.List;

import com.journaldev.spring.model.Person;
import com.journaldev.spring.model.StaffHasPerson;

public interface PersonService {

	public void addPerson(Person p);
	public void updatePerson(Person p);
	public List<Person> listPersons();
	public Person getPersonById(int id);
	public void removePerson(int id);
	
	public List<StaffHasPerson> getStaffByPersonId(int personId);
}
