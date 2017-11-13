package com.solstice.contact.web.activity;

import java.util.List;

import com.solstice.contact.service.ContactService;
import com.solstice.contact.web.representations.ContactRepresentation;
import com.solstice.contact.web.requests.ContactRequest;

public interface ContactActivity {

	public ContactService getContactService();

	public void setContactService(ContactService contactService);

	public List<ContactRepresentation> listContacts();

	public ContactRepresentation createContact(ContactRequest contactRequest);

}
