package com.solstice.contact.web.resource.test;

import java.util.List;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.solstice.common.constants.AppBaseConstantsWeb;
import com.solstice.common.utility.AppBaseUtilsWeb;
import com.solstice.contact.web.representations.AddressRepresentation;
import com.solstice.contact.web.representations.ContactRepresentation;
import com.solstice.contact.web.resource.impl.ContactResourceImpl;

public class ContactResourceImplTest extends Assert {
	ContactResourceImpl contactResourceImpl;

	@BeforeClass
	public static void initialize() throws Exception {
		AppBaseUtilsWeb.startServerLocal((ContactResourceImpl) new ClassPathXmlApplicationContext("JUnit_context.xml")
				.getBean("contactResourceImpl"));
	}

	@AfterClass
	public static void destroy() throws Exception {
		AppBaseUtilsWeb.stopServerLocal();
	}

	@SuppressWarnings("unchecked")
	@Test
	public void listContactsTest() {
		List<ContactRepresentation> listContactRepresentation;
		listContactRepresentation = (List<ContactRepresentation>) AppBaseUtilsWeb.createWebClientJUnitTest("contact")
				.getCollection(ContactRepresentation.class);
		assertNotNull(listContactRepresentation);
	}

	@Test
	public void createContactTest() {
		ContactRepresentation contactRepresentation = new ContactRepresentation(null, "Percy Soliz", "Solstice",
				AppBaseConstantsWeb.ENCODED_IMAGE, "percy.soliz.rodriguez@gmail.com", "02/01/1988", "312-383-8870",
				null, new AddressRepresentation(null, "1068 W Granville Ave", "22", "Chicago", "IL", "60660"));
		contactRepresentation = AppBaseUtilsWeb.createWebClientJUnitTest("contact").post(contactRepresentation,
				ContactRepresentation.class);
		assertNotNull(contactRepresentation);
		assertEquals(contactRepresentation.getName(), "Percy Soliz");
		assertEquals(contactRepresentation.getBirthdate(), "02/01/1988");
	}

	@Test
	public void deleteContactTest() {
		Response response = AppBaseUtilsWeb.createWebClientJUnitTest("contact/1").delete();
		assertNotNull(response);
		assertEquals(response.getStatus(), Status.BAD_REQUEST.getStatusCode());
	}

	@Test
	public void getContactById() {
		ContactRepresentation contactRepresentation = AppBaseUtilsWeb.createWebClientJUnitTest("contact/10")
				.get(ContactRepresentation.class);
		assertNotNull(contactRepresentation);
		assertEquals(contactRepresentation.getName(), "Peter Parker");
	}

	@Test
	public void updateContact() {
		ContactRepresentation contactRepresentation = AppBaseUtilsWeb.createWebClientJUnitTest("contact/10")
				.get(ContactRepresentation.class);
		contactRepresentation.setName("Peter Parker");
		Response response = AppBaseUtilsWeb.createWebClientJUnitTest("contact/10").put(contactRepresentation);
		assertNotNull(response);
		assertEquals(response.getStatus(), Status.OK.getStatusCode());
	}

	@SuppressWarnings("unchecked")
	@Test
	public void listContactsByEmail() {
		List<ContactRepresentation> listContactRepresentation;
		listContactRepresentation = (List<ContactRepresentation>) AppBaseUtilsWeb.createWebClientJUnitTest("contact/email/batman")
				.getCollection(ContactRepresentation.class);
		assertNotNull(listContactRepresentation);
	}

	@SuppressWarnings("unchecked")
	@Test
	public void listContactsByPhoneNumber() {
		List<ContactRepresentation> listContactRepresentation;
		listContactRepresentation = (List<ContactRepresentation>) AppBaseUtilsWeb.createWebClientJUnitTest("contact/phoneNumber/312")
				.getCollection(ContactRepresentation.class);
		assertNotNull(listContactRepresentation);
	}

	@SuppressWarnings("unchecked")
	@Test
	public void listContactsByCity() {
		List<ContactRepresentation> listContactRepresentation;
		listContactRepresentation = (List<ContactRepresentation>) AppBaseUtilsWeb.createWebClientJUnitTest("contact/address/city/Chicago")
				.getCollection(ContactRepresentation.class);
		assertNotNull(listContactRepresentation);
	}

	@SuppressWarnings("unchecked")
	@Test
	public void listContactsByState() {
		List<ContactRepresentation> listContactRepresentation;
		listContactRepresentation = (List<ContactRepresentation>) AppBaseUtilsWeb.createWebClientJUnitTest("contact/address/state/IL")
				.getCollection(ContactRepresentation.class);
		assertNotNull(listContactRepresentation);
	}

}