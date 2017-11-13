package com.solstice.contact.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.solstice.common.dao.AbstractBaseDao;
import com.solstice.common.model.Contact;
import com.solstice.contact.dao.ContactDao;

@SuppressWarnings("rawtypes")
@Repository
public class ContactDaoImpl extends AbstractBaseDao implements ContactDao {

	@SuppressWarnings("unchecked")
	@Transactional
	public Contact save(Contact contact) {
		return (Contact) super.store(contact);
	}

	public List<Contact> listAll() {
		return super.verifyListNamedQueryAll("com.solstice.contact.dao.impl.ContactDaoImpl.listAll");
	}

	@Transactional
	public boolean remove(Contact contact) {
		return super.remove(contact);

	}

	@Override
	public Contact getById(Long contactId) {
		return super.verifyNamedQueryAll("com.solstice.contact.dao.impl.ContactDaoImpl.getById", contactId);
	}
}