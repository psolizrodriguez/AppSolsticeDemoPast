package com.solstice.contact.web.resource;

import java.util.List;

import javax.jws.WebService;

import com.solstice.contact.web.representations.ContactRepresentation;

@WebService
public interface SearchResource {

	public ContactRepresentation findContact(String email, String phoneNumber);

	public List<ContactRepresentation> findContactsByAddress(String city, String state);

}
