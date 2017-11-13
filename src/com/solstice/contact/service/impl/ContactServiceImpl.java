package com.solstice.contact.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.solstice.common.model.Contact;
import com.solstice.contact.dao.ContactDao;
import com.solstice.contact.service.ContactService;

@Service
public class ContactServiceImpl implements ContactService {
	@Autowired
	ContactDao contactDao;

	@Override
	public Contact save(Contact contact) {
		return contactDao.save(contact);
	}

	@Override
	public List<Contact> listAll() {
		return contactDao.listAll();
	}

	@Override
	public Contact getById(Long contactId) {
		return contactDao.getById(contactId);
	}

	@Override
	public boolean remove(Contact contact) {
		return contactDao.remove(contact);
	}

}
