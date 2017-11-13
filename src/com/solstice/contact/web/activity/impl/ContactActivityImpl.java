package com.solstice.contact.web.activity.impl;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.solstice.common.constants.AppBaseConstantsWeb;
import com.solstice.common.model.Address;
import com.solstice.common.model.Contact;
import com.solstice.common.utility.AppBaseUtilsWeb;
import com.solstice.contact.service.ContactService;
import com.solstice.contact.web.activity.ContactActivity;
import com.solstice.contact.web.representations.ContactRepresentation;
import com.solstice.contact.web.requests.ContactRequest;

@Service
public class ContactActivityImpl implements ContactActivity {

	@Autowired
	ContactService contactService;

	@Override
	public List<ContactRepresentation> listContacts() {
		List<ContactRepresentation> listContactRepresentation = new ArrayList<>();
		List<Contact> listContact = new ArrayList<>();
		listContact = contactService.listAll();
		Iterator<Contact> it = listContact.iterator();
		while (it.hasNext()) {
			listContactRepresentation.add(new ContactRepresentation((Contact) it.next()));
		}
		return listContactRepresentation;
	}

	public Contact createContactFromContactRequest(ContactRequest contactRequest, Contact contact) {
		String encodedImage = contactRequest.getProfileImage();
		contactRequest.setProfileImage(null);
		Long contactId = null;
		Long addressId = null;
		if (contact != null) {
			contactId = contact.getContactId();
			addressId = contact.getAddress().getAddressId();
		}
		contact = new Contact(contactId, contactRequest.getName(), contactRequest.getCompany(),
				contactRequest.getProfileImage(), contactRequest.getEmail(),
				AppBaseUtilsWeb.StringToCalendar(contactRequest.getBirthdate(), AppBaseConstantsWeb.DATE_FORMAT),
				contactRequest.getPersonalPhoneNumber(), contactRequest.getWorkPhoneNumber(),
				new Address(addressId, contactRequest.getAddress().getStreet(), contactRequest.getAddress().getUnit(),
						contactRequest.getAddress().getCity(), contactRequest.getAddress().getState(),
						contactRequest.getAddress().getZip()));
		contact = contactService.save(contact);
		if (contact != null) {
			// Saving profileImage into the server
			BufferedImage profileImage = AppBaseUtilsWeb.decodeToImage(encodedImage);
			AppBaseUtilsWeb.saveImageToServer(profileImage, String.valueOf(contact.getContactId()));
		}
		return contact;
	}

	@Override
	public ContactRepresentation createContact(ContactRequest contactRequest) {
		return new ContactRepresentation(createContactFromContactRequest(contactRequest, null));
	}

	@Override
	public boolean deleteContact(Long contactId) {
		Contact contact = contactService.getById(contactId);
		if (contact != null) {
			return contactService.remove(contact);
		}
		return false;
	}

	@Override
	public ContactRepresentation getContactById(Long contactId) {
		Contact contact = contactService.getById(contactId);
		if (contact != null) {
			return new ContactRepresentation(contact);
		}
		return null;
	}

	@Override
	public boolean updateContact(Long contactId, ContactRequest contactRequest) {
		Contact contact = contactService.getById(contactId);
		if (contact != null) {
			return createContactFromContactRequest(contactRequest, contact) != null;
		}
		return false;
	}

}
