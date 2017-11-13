package com.solstice.contact.dao;

import java.util.List;

import com.solstice.common.dao.Dao;
import com.solstice.common.model.Contact;

public interface ContactDao extends Dao {
	public Contact save(Contact contact);

	public List<Contact> listAll();

	public Contact getById(Long contactId);

	public boolean remove(Contact contact);

	public List<Contact> listContactsByEmail(String email);

	public List<Contact> listContactsByPhoneNumber(String phoneNumber);

	public List<Contact> listContactsByCity(String city);

	public List<Contact> listContactsByState(String state);

}
