package com.journaldev.spring;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.journaldev.spring.model.Person;
import com.journaldev.spring.model.Staff;
import com.journaldev.spring.model.StaffHasPerson;
import com.journaldev.spring.service.PersonService;

@Controller
public class PersonController {
	
	private PersonService personService;
	
	@Autowired(required=true)
	@Qualifier(value="personService")
	public void setPersonService(PersonService ps){
		this.personService = ps;
	}
	
	@RequestMapping(value = "/persons", method = RequestMethod.GET)
	public String listPersons(Model model) {
		List<Person> manyperson = this.personService.listPersons();
        for (Person person : manyperson) {
            List<StaffHasPerson> staffList = this.personService.getStaffByPersonId(person.getId());
            person.setStaffList(staffList); 
        }
		model.addAttribute("person", new Person());
		model.addAttribute("listPersons", this.personService.listPersons());
		return "person";
	}
	
	//For add and update person both
	@RequestMapping(value= "/person/add", method = RequestMethod.POST)
	public String addPerson(@ModelAttribute("person") Person p){
		
		if(p.getId() == 0){
			//new person, add it
			this.personService.addPerson(p);
		}else{
			//existing person, call update
			this.personService.updatePerson(p);
		}
		
		return "redirect:/persons";
		
	}
	
	@RequestMapping("/remove/{id}")
    public String removePerson(@PathVariable("id") int id){
		
        this.personService.removePerson(id);
        return "redirect:/persons";
    }
 
    @RequestMapping("/edit/{id}")
    public String editPerson(@PathVariable("id") int id, Model model){
        model.addAttribute("person", this.personService.getPersonById(id));
        model.addAttribute("listPersons", this.personService.listPersons());
        return "person";
    }
    
    
	/*
	 * @RequestMapping("/person/{id}/staff") public String
	 * viewStaffForPerson(@PathVariable("id") int id, Model model){
	 * List<StaffHasPerson> staffList = this.personService.getStaffByPersonId(id);
	 * model.addAttribute("person", this.personService.getPersonById(id));
	 * model.addAttribute("staffList", staffList); return "staffperson"; // This
	 * will be the new JSP page for displaying staff members }
	 */
	
}
