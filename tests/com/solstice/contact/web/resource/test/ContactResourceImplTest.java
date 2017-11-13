package com.solstice.contact.web.resource.test;

import java.io.InputStream;
import java.util.List;

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
	public void storeImage() {
		InputStream image = getClass().getClassLoader().getResourceAsStream("testProfile.jpg");
		assertNotNull(image);
	}

	/*
	 * @Test public void testGetBookWithWebClient() { WebClient client =
	 * WebClient.create(ENDPOINT_ADDRESS);
	 * WebClient.getConfig(client).getRequestContext().put(LocalConduit.
	 * DIRECT_DISPATCH, Boolean.TRUE); client =
	 * client.accept("application/json").type("application/json").path("/contact");
	 * String getRequestURI = client.getCurrentURI().toString();
	 * System.out.println("Client GET METHOD Request URI:  " + getRequestURI);
	 * ContactRepresentation contactRepresentation =
	 * client.get(ContactRepresentation.class); assertEquals("Percy Soliz",
	 * contactRepresentation.getName()); }
	 * 
	 * 
	 * EmployeeRequest employeeRequest = new EmployeeRequest();
	 * employeeRequest.setFirstName("Michael");
	 * employeeRequest.setLastName("Gerard");
	 * 
	 * String responsePost = postClient.post(employeeRequest, String.class);
	 */
}