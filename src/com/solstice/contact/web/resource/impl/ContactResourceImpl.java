package com.solstice.contact.web.resource.impl;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.springframework.beans.factory.annotation.Autowired;

import com.solstice.contact.web.activity.ContactActivity;
import com.solstice.contact.web.representations.ContactRepresentation;
import com.solstice.contact.web.requests.ContactRequest;
import com.solstice.contact.web.resource.ContactResource;

@Path("contact")
@Produces({ "application/json" })
public class ContactResourceImpl implements ContactResource {

	@Autowired
	ContactActivity contactActivity;

	@GET
	public List<ContactRepresentation> listContacts() {
		return contactActivity.listContacts();
	}

	@GET
	@Path("email/{email}")
	public List<ContactRepresentation> listContactsByEmail(@PathParam("email") String email) {
		System.out.println("In listContactsByEmail");
		System.out.println("email : " + email);
		return contactActivity.listContactsByEmail(email);
	}

	@GET
	@Path("phoneNumber/{phoneNumber}")
	public List<ContactRepresentation> listContactsByPhoneNumber(@PathParam("phoneNumber") String phoneNumber) {
		System.out.println("In listContactsByPhoneNumber");
		System.out.println("phoneNumber : " + phoneNumber);
		return contactActivity.listContactsByPhoneNumber(phoneNumber);
	}

	@GET
	@Path("address/city/{city}")
	public List<ContactRepresentation> listContactsByCity(@PathParam("city") String city) {
		System.out.println("In listContactsByCity");
		System.out.println("city : " + city);
		return contactActivity.listContactsByCity(city);
	}

	@GET
	@Path("address/state/{state}")
	public List<ContactRepresentation> listContactsByState(@PathParam("state") String state) {
		System.out.println("In listContactsByState");
		System.out.println("state : " + state);
		return contactActivity.listContactsByState(state);
	}

	@POST
	public ContactRepresentation createContact(ContactRequest contactRequest) {
		return contactActivity.createContact(contactRequest);
	}

	@PUT
	@Path("{contactId}")
	public Response updateContact(@PathParam("contactId") Long contactId, ContactRequest contactRequest) {
		if (contactActivity.updateContact(contactId, contactRequest)) {
			return Response.status(Status.OK).build();
		}
		return Response.status(Status.BAD_REQUEST).build();
	}

	@DELETE
	@Path("{contactId}")
	public Response deleteContact(@PathParam("contactId") Long contactId) {
		if (contactActivity.deleteContact(contactId)) {
			return Response.status(Status.OK).build();
		}
		return Response.status(Status.BAD_REQUEST).build();
	}

	@GET
	@Path("{contactId}")
	public ContactRepresentation getContactById(@PathParam("contactId") Long contactId) {
		return contactActivity.getContactById(contactId);
	}
}