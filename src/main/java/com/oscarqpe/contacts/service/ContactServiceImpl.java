package com.oscarqpe.contacts.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oscarqpe.contacts.dao.ContactDao;
import com.oscarqpe.contacts.dto.Contact;

@Service("contactService")
public class ContactServiceImpl implements ContactService {
	@Autowired
	private ContactDao contactDao;
	@Override
	public List<Contact> getContactos() {
		return contactDao.getContactos();
	}
	@Override
	public void createBatch() {
		List<Contact> contactos = new ArrayList<>();
		for (int i = 0; i < 1000; i++) {
			Contact contact = new Contact(1L, "Oscar", "Edmit", "123456789", "oscarqpe@gmail.com");
			contactos.add(contact);
		}
		this.contactDao.createBatch(contactos);
	}
}
