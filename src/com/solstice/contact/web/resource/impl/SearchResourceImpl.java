package com.solstice.contact.web.resource.impl;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import org.springframework.beans.factory.annotation.Autowired;

import com.solstice.contact.web.activity.ContactActivity;
import com.solstice.contact.web.representations.ContactRepresentation;
import com.solstice.contact.web.resource.SearchResource;

@Path("searchContact")
@Produces({ "application/json" })
public class SearchResourceImpl implements SearchResource {

	@Autowired
	ContactActivity ContactActivity;

	@GET
	public ContactRepresentation findContact(@QueryParam("email") String email,
			@QueryParam("phoneNumber") String phoneNumber) {
		System.out.println("In findContacts");
		System.out.println("email : " + email);
		System.out.println("phoneNumber : " + phoneNumber);
		return null;
	}

	@GET
	@Path("address")
	public List<ContactRepresentation> findContactsByAddress(@QueryParam("city") String city,
			@QueryParam("state") String state) {
		System.out.println("In findContactsByAddress");
		System.out.println("city : " + city);
		System.out.println("state : " + state);
		return null;
	}

}