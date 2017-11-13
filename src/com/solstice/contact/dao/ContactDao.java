package com.solstice.contact.dao;

import java.util.List;

import com.solstice.common.dao.Dao;
import com.solstice.common.model.Contact;

public interface ContactDao extends Dao {
	public Contact save(Contact contact);

	public List<Contact> listAll();

	public Contact getById(Long contactId);

	public boolean remove(Contact contact);

}
