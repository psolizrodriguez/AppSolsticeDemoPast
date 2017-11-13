package com.solstice.contact.web.resource;

import java.util.List;

import javax.jws.WebService;
import javax.ws.rs.core.Response;

import com.solstice.contact.web.representations.ContactRepresentation;
import com.solstice.contact.web.requests.ContactRequest;

@WebService
public interface ContactResource {

	public List<ContactRepresentation> listContacts();

	public ContactRepresentation createContact(ContactRequest contactRequest);

	public Response updateContact(Long contactId, ContactRequest contactRequest);

	public Response deleteContact(Long contactId);

	public ContactRepresentation getContactById(Long contactId);

	public List<ContactRepresentation> listContactsByEmail(String email);

	public List<ContactRepresentation> listContactsByPhoneNumber(String phoneNumber);

	public List<ContactRepresentation> listContactsByCity(String city);

	public List<ContactRepresentation> listContactsByState(String state);

}
