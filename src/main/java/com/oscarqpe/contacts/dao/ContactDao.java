package com.oscarqpe.contacts.dao;

import java.util.List;

import com.oscarqpe.contacts.dto.Contact;

public interface ContactDao {
	List<Contact> getContactos();
	void createBatch(List<Contact> contactos);
}
