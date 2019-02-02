package com.oscarqpe.contacts.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.oscarqpe.contacts.dto.Contact;
import com.oscarqpe.contacts.service.ContactService;

@RestController
public class ContactsApi {
	@Autowired
	ContactService contactService;
	@RequestMapping(value = "/contact", method = RequestMethod.GET)
	public List<Contact> getById() {
		
		return contactService.getContactos();
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public boolean create() {
		contactService.createBatch();
		return true;
	}
}
