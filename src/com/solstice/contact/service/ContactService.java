package com.solstice.contact.service;

import java.util.List;

import com.solstice.common.model.Contact;

public interface ContactService {
	public Contact save(Contact contact);

	public List<Contact> listAll();

	public Contact getById(Long contactId);

	public boolean remove(Contact contact);
}
