package com.solstice.contact.web.activity;

import java.util.List;

import com.solstice.contact.web.representations.ContactRepresentation;
import com.solstice.contact.web.requests.ContactRequest;

public interface ContactActivity {

	public List<ContactRepresentation> listContacts();

	public ContactRepresentation createContact(ContactRequest contactRequest);

	public boolean deleteContact(Long contactId);

	public boolean updateContact(Long contactId, ContactRequest contactRequest);

	public ContactRepresentation getContactById(Long contactId);
	
	public List<ContactRepresentation> listContactsByEmail(String email);

	public List<ContactRepresentation> listContactsByPhoneNumber(String phoneNumber);

	public List<ContactRepresentation> listContactsByCity(String city);

	public List<ContactRepresentation> listContactsByState(String state);

}
