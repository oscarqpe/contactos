package com.oscarqpe.contacts.service;

import java.util.List;

import com.oscarqpe.contacts.dto.Contact;

public interface ContactService {
	List<Contact> getContactos();
	void createBatch();
}
