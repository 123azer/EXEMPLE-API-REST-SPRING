package com.example.demo.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.ContactRepository;
import com.example.demo.entities.Contact;

@RestController
public class ContactRestService {
@Autowired
private ContactRepository contactRepository;
	
@RequestMapping(value="/contact",method=RequestMethod.GET)
public List <Contact> getContact(){
	return contactRepository.findAll();
}

@RequestMapping(value="/contact/{id}",method=RequestMethod.GET)
public Contact getContact(@PathVariable Long id){
	return contactRepository.findOne(id);
}

@RequestMapping(value="/contact",method=RequestMethod.POST)
public Contact save(@RequestBody Contact contact){
	return contactRepository.save(contact);
}

@RequestMapping(value="/contact/{id}",method=RequestMethod.DELETE)
public boolean supprimer(@PathVariable Long id){
	 contactRepository.delete(id);
	 return true;
}

@RequestMapping(value="/contact/{id}",method=RequestMethod.PUT)
public Contact save(@PathVariable Long id,@RequestBody Contact contact){
	//Contact c = contactRepository.findOne(id);
	//if(contact.getPhoto()==null)
	//	contact.setPhoto(c.getPhoto());
	contact.setId(id);
	return contactRepository.save(contact);
}

@RequestMapping(value="/cherchercontact",method=RequestMethod.GET)
public Page<Contact>  getContact(@RequestParam(name = "mc",defaultValue="")String mc
		,@RequestParam(name = "page",defaultValue="0")int page,
		@RequestParam(name = "size",defaultValue="5")int size){
	return contactRepository.Chercher("%"+mc+"%", new PageRequest(page, size));
}

}
