package com.example.demo;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.dao.ContactRepository;
import com.example.demo.entities.Contact;

@SpringBootApplication
public class ContactApplication implements CommandLineRunner  {
	
	@Autowired
    private ContactRepository contactRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(ContactApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
      		contactRepository.save(new Contact("badr", "el kantouri",df.parse("12/01/1999"),"badr@gmail.com",new Long(65098),"p1.jpg"));
      		contactRepository.save(new Contact("amine", "el amrani",df.parse("12/08/1998"),"amine@gmail.com",new Long(65098),"p2.jpg"));
      		contactRepository.save(new Contact("adil", "el taqi",df.parse("12/01/2000"),"adil@gmail.com",new Long(65098),"p3.jpg"));
      		contactRepository.findAll().forEach(c->{
      			System.out.println(c.getNom());
      		});
      		
	}
}
