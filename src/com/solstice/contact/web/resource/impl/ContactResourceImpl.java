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

	@POST
	public ContactRepresentation createContact(ContactRequest contactRequest) {
		return contactActivity.createContact(contactRequest);
	}

	@PUT
	@Path("{contactId}")
	public Response updateContact(@PathParam("contactId") Long contactId, ContactRequest contactRequest) {
		// TODO Auto-generated method stub
		System.out.println("Entra a update");
		return Response.status(Status.OK).build();
	}

	@DELETE
	@Path("{contactId}")
	public Response deleteContact(@PathParam("contactId") Long contactId) {
		// TODO Auto-generated method stub
		System.out.println("Entra a delete");
		return Response.status(Status.OK).build();
	}

	@GET
	@Path("{contactId}")
	public ContactRepresentation getContactById(@PathParam("contactId") Long contactId) {
		// TODO Auto-generated method stub
		System.out.println("Entra a get by id");
		return null;
	}

	public ContactActivity getContactActivity() {
		return contactActivity;
	}

	public void setContactActivity(ContactActivity contactActivity) {
		this.contactActivity = contactActivity;
	}

}