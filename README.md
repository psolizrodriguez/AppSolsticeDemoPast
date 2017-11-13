# Backend Coding Challenge for Solstice  

## Position  
[Senior Java/Spring Developer](https://stackoverflow.com/jobs/158140/senior-java-spring-developer-solstice)  

## Applicant 
**-Name:** [Percy Soliz](https://www.linkedin.com/in/psolizrodriguez/)  
**-Email:** percy.soliz.rodriguez@gmail.com  
**-Phone Number:** 312-383-8870  

## Purpose
As part of Solstice’s hiring process, we ask interviewees to complete a small project to help assess skill, experience, ingenuity, problem-solving and knowledge.  

## Scope
Develop a RESTful API that would allow a web or mobile front-end to:  
-Create a contact record  
-Retrieve a contact record  
-Update a contact record  
-Delete a contact record  
-Search for a record by email or phone number  
-Retrieve all records from the same state or city  
The contact record should represent the following information: name, company, profile image, email, birthdate, phone number (work, personal) and address .  
Also please provide a unit test for at least one of the endpoints you create.  

## Solution Description

The implemented solution is running on an Apache Tomcat Server 9.0 and has the following features:  
-Hibernate 3.6 and JPA 2.0 for handling the persistence layer.  
-Spring Framework 3 for handling the dependency injection.  
-Apache CXF 2.7 for the management of endpoints and JAXRS as marshaler.  
-JUnit 4 and JAXRS server for testing.  

## Import Project in Eclipse
1) Create directory "AppSolsticeDemo" inside of your workspace  
2) Execute the following code inside of that directory once Git is installed in your machine: 
```
git init  
git remote add AppSolsticeDemo https://github.com/psolizrodriguez/AppSolsticeDemo.git  
git pull AppSolsticeDemo master
```
3) Create a Dynamic Web with tomcat 9 as container in Eclipse using that path  
4) Add CXF 2.7 Runtime to the Runtime Libraries of the project in Eclipse

## Test Client

A pure JavaScript and JQuery client was created in order to provide a GUI and a faster way of visually testing the endpoints. The code of this client is located at the "Web Content" folder of the same project, and is currently being hosted at:  
http://18.220.231.8:8080/AppSolsticeDemo/  

## Package Structure
**-com.solstice.common.model:** Contains the Entities.  
**-com.solstice.contact.dao:** Contains the DAO layer.  
**-com.solstice.contact.service:** Contains the Spring Service layer.  
**-com.solstice.contact.web.activity:** Contains the classes to help process data to the endpoints.  
**-com.solstice.contact.web.representations:** Contains the beans for parsing the data between server and client.  
**-com.solstice.contact.web.request:** Contains the beans for parsing the data between client and server.  
**-com.solstice.contact.web.resource:** Contains the classes that represent the available endpoints to the clients. 
**-com.solstice.contact.web.resource.test:** Contains the classes with the JUnit test cases for the endpoins. 

## Data Base Connection Details
**HeidiSQL:** https://www.heidisql.com/  
**DBMS:** MySQL 5.7  
**Host:** 18.220.231.8  
**Database:** solsticeDemo  
**User:** solstice  
**Password:** solstice  

## Class Diagram  
![Class Diagram](https://i.imgur.com/jQ3zazu.png)  

## Entity Relationship Diagram  
![ERD](https://i.imgur.com/YMEcBxP.png)  

## Endpoints 
### 1. com.solstice.contact.web.resource.impl.ContactResourceImpl.java (/contact)
#### a. List all Contacts
##### Description: 
This method returns all the records of the Contact table
##### URI: 
http://18.220.231.8:8080/AppSolsticeDemo/services/contact 
##### Parameters
```
none
```
##### Method: 
GET  
##### Headers:   
```
Accept:application/json  
```
##### Body:  
```
none
```
##### Response:  
Collection of ContactRepresentation type.  
```
[
     {
        "contactId": 10,
        "name": "Peter Parker",
        "company": "Solstice",
        "profileImage": "http://18.220.231.8:8080/AppSolsticeDemo/viewContactPicture.html?contactId=10",
        "email": "peter.parker@gmail.com",
        "birthdate": "02/01/1988",
        "personalPhoneNumber": "312-383-8870",
        "workPhoneNumber": "312-383-8870",
        "address": {
            "addressId": 10,
            "street": "1068 W Granville Ave",
            "unit": "22",
            "city": "Chicago",
            "state": "IL",
            "zip": "60660"
        },
        "link": [
            {
                "type": "application/json",
                "method": "DELETE",
                "rel": "delete",
                "href": "http://18.220.231.8:8080/AppSolsticeDemo/services/contact/10"
            },
            {
                "type": "application/json",
                "method": "GET",
                "rel": "refresh",
                "href": "http://18.220.231.8:8080/AppSolsticeDemo/services/contact/10"
            },
            {
                "type": "application/json",
                "method": "PUT",
                "rel": "modify",
                "href": "http://18.220.231.8:8080/AppSolsticeDemo/services/contact/10"
            }
        ]
    }
]
```
#### b. List all Contacts by Email  (/email/{email})
##### Description: 
This method returns all the records of the Contact table with matching email
##### URI: 
http://18.220.231.8:8080/AppSolsticeDemo/services/contact/email/jane.doe 
##### Parameters
**-email:** string to search on database
##### Method: 
GET  
##### Headers:   
```
Accept:application/json  
```
##### Body:  
```
none
```
##### Response:  
Collection of ContactRepresentation type.  
```
[
    {
        "contactId": 33,
        "name": "Jane Doe",
        "company": "Microsoft",
        "profileImage": "http://18.220.231.8:8080/AppSolsticeDemo/viewContactPicture.html?contactId=33",
        "email": "jane.doe@gmail.com",
        "birthdate": "01/01/1990",
        "personalPhoneNumber": "312-333-3123",
        "workPhoneNumber": "",
        "address": {
            "addressId": 33,
            "street": "Randolph",
            "unit": "34",
            "city": "Chicago",
            "state": "IL",
            "zip": "60611"
        },
        "link": [
            {
                "type": "application/json",
                "method": "DELETE",
                "rel": "delete",
                "href": "http://18.220.231.8:8080/AppSolsticeDemo/services/contact/33"
            },
            {
                "type": "application/json",
                "method": "GET",
                "rel": "refresh",
                "href": "http://18.220.231.8:8080/AppSolsticeDemo/services/contact/33"
            },
            {
                "type": "application/json",
                "method": "PUT",
                "rel": "modify",
                "href": "http://18.220.231.8:8080/AppSolsticeDemo/services/contact/33"
            }
        ]
    }
]
```
#### c. List all Contacts by Phone Number  (/phoneNumber/{phoneNumber})
##### Description: 
This method returns all the records of the Contact table with matching personal or work phone number
##### URI: 
http://18.220.231.8:8080/AppSolsticeDemo/services/contact/phoneNumber/312
##### Parameters
**-phoneNumber:** string to search on database
##### Method: 
GET  
##### Headers:   
```
Accept:application/json  
```
##### Body:  
```
none
```
##### Response:  
Collection of ContactRepresentation type.  
```
[
    {
        "contactId": 33,
        "name": "Jane Doe",
        "company": "Microsoft",
        "profileImage": "http://18.220.231.8:8080/AppSolsticeDemo/viewContactPicture.html?contactId=33",
        "email": "jane.doe@gmail.com",
        "birthdate": "01/01/1990",
        "personalPhoneNumber": "312-333-3123",
        "workPhoneNumber": "",
        "address": {
            "addressId": 33,
            "street": "Randolph",
            "unit": "34",
            "city": "Chicago",
            "state": "IL",
            "zip": "60611"
        },
        "link": [
            {
                "type": "application/json",
                "method": "DELETE",
                "rel": "delete",
                "href": "http://18.220.231.8:8080/AppSolsticeDemo/services/contact/33"
            },
            {
                "type": "application/json",
                "method": "GET",
                "rel": "refresh",
                "href": "http://18.220.231.8:8080/AppSolsticeDemo/services/contact/33"
            },
            {
                "type": "application/json",
                "method": "PUT",
                "rel": "modify",
                "href": "http://18.220.231.8:8080/AppSolsticeDemo/services/contact/33"
            }
        ]
    }
]
```
#### d. List all Contacts by City (/address/city/{city})
##### Description: 
This method returns all the records of the Contact with matching city on their address 
##### URI: 
http://18.220.231.8:8080/AppSolsticeDemo/services/contact/address/city/Chicago 
##### Parameters
**-city:** string to search on database
##### Method: 
GET  
##### Headers:   
```
Accept:application/json  
```
##### Body:  
```
none
```
##### Response:  
Collection of ContactRepresentation type.  
```
[
    {
        "contactId": 33,
        "name": "Jane Doe",
        "company": "Microsoft",
        "profileImage": "http://18.220.231.8:8080/AppSolsticeDemo/viewContactPicture.html?contactId=33",
        "email": "jane.doe@gmail.com",
        "birthdate": "01/01/1990",
        "personalPhoneNumber": "312-333-3123",
        "workPhoneNumber": "",
        "address": {
            "addressId": 33,
            "street": "Randolph",
            "unit": "34",
            "city": "Chicago",
            "state": "IL",
            "zip": "60611"
        },
        "link": [
            {
                "type": "application/json",
                "method": "DELETE",
                "rel": "delete",
                "href": "http://18.220.231.8:8080/AppSolsticeDemo/services/contact/33"
            },
            {
                "type": "application/json",
                "method": "GET",
                "rel": "refresh",
                "href": "http://18.220.231.8:8080/AppSolsticeDemo/services/contact/33"
            },
            {
                "type": "application/json",
                "method": "PUT",
                "rel": "modify",
                "href": "http://18.220.231.8:8080/AppSolsticeDemo/services/contact/33"
            }
        ]
    }
]
```
#### e. List all Contacts by State (/address/state/{state})
##### Description: 
This method returns all the records of the Contact with matching state on their address 
##### URI: 
http://18.220.231.8:8080/AppSolsticeDemo/services/contact/address/state/IL 
##### Parameters
**-state:** string to search on database
##### Method: 
GET  
##### Headers:   
```
Accept:application/json  
```
##### Body:  
```
none
```
##### Response:  
Collection of ContactRepresentation type.  
```
[
    {
        "contactId": 33,
        "name": "Jane Doe",
        "company": "Microsoft",
        "profileImage": "http://18.220.231.8:8080/AppSolsticeDemo/viewContactPicture.html?contactId=33",
        "email": "jane.doe@gmail.com",
        "birthdate": "01/01/1990",
        "personalPhoneNumber": "312-333-3123",
        "workPhoneNumber": "",
        "address": {
            "addressId": 33,
            "street": "Randolph",
            "unit": "34",
            "city": "Chicago",
            "state": "IL",
            "zip": "60611"
        },
        "link": [
            {
                "type": "application/json",
                "method": "DELETE",
                "rel": "delete",
                "href": "http://18.220.231.8:8080/AppSolsticeDemo/services/contact/33"
            },
            {
                "type": "application/json",
                "method": "GET",
                "rel": "refresh",
                "href": "http://18.220.231.8:8080/AppSolsticeDemo/services/contact/33"
            },
            {
                "type": "application/json",
                "method": "PUT",
                "rel": "modify",
                "href": "http://18.220.231.8:8080/AppSolsticeDemo/services/contact/33"
            }
        ]
    }
]
```
#### f. Retrieve a contact record (/{contactId})
##### Description: 
This method returns one record corresponding the contactId sent on the URL
##### URI: 
http://18.220.231.8:8080/AppSolsticeDemo/services/contact/10
##### Parameters
**-contactId:** variable of type Long, referencing the contactId of the Contact to be retrieved
##### Method: 
GET  
##### Headers:   
```
Accept:application/json  
```
##### Body:  
```
none
```
##### Response:  
Object of ContactRepresentation type.  
```
{
    "contactId": 10,
    "name": "Peter Parker",
    "company": "Solstice",
    "profileImage": "http://18.220.231.8:8080/AppSolsticeDemo/viewContactPicture.html?contactId=10",
    "email": "peter.parker@gmail.com",
    "birthdate": "02/01/1988",
    "personalPhoneNumber": "312-383-8870",
    "workPhoneNumber": "312-383-8870",
    "address": {
        "addressId": 10,
        "street": "1068 W Granville Ave",
        "unit": "22",
        "city": "Chicago",
        "state": "IL",
        "zip": "60660"
    },
    "link": [
        {
            "type": "application/json",
            "method": "DELETE",
            "rel": "delete",
            "href": "http://18.220.231.8:8080/AppSolsticeDemo/services/contact/10"
        },
        {
            "type": "application/json",
            "method": "GET",
            "rel": "refresh",
            "href": "http://18.220.231.8:8080/AppSolsticeDemo/services/contact/10"
        },
        {
            "type": "application/json",
            "method": "PUT",
            "rel": "modify",
            "href": "http://18.220.231.8:8080/AppSolsticeDemo/services/contact/10"
        }
    ]
}
```
#### g. Create a contact record
##### Description: 
This method allows us to create a new Contact 
##### URI: 
http://18.220.231.8:8080/AppSolsticeDemo/services/contact
##### Parameters
```
none
```
##### Method: 
POST  
##### Headers:   
```
Accept:application/json  
Content-Type:application/json  
```
##### Body:  
Object of ContactRequest type.

```
{
	"name": "Clark Kent",
    "company": "Planet",
    "profileImage": "",
    "email": "clark.kent@gmail.com",
    "birthdate": "01/01/1990",
    "personalPhoneNumber": "312-333-5555",
    "workPhoneNumber": "312-333-5554",
    "address": {
        "street": "Michigan Ave",
        "unit": "22",
        "city": "Rochester",
        "state": "NY",
        "zip": "60400"
    }
}
```
##### Response:  
Object of ContactRepresentation type.

```
{
    "contactId": 35,
    "name": "Clark Kent",
    "company": "Planet",
    "profileImage": "http://18.220.231.8:8080/AppSolsticeDemo/viewContactPicture.html?contactId=35",
    "email": "clark.kent@gmail.com",
    "birthdate": "01/01/1990",
    "personalPhoneNumber": "312-333-5555",
    "workPhoneNumber": "312-333-5554",
    "address": {
        "addressId": 35,
        "street": "Michigan Ave",
        "unit": "22",
        "city": "Rochester",
        "state": "NY",
        "zip": "60400"
    },
    "link": [
        {
            "type": "application/json",
            "method": "DELETE",
            "rel": "delete",
            "href": "http://18.220.231.8:8080/AppSolsticeDemo/services/contact/35"
        },
        {
            "type": "application/json",
            "method": "GET",
            "rel": "refresh",
            "href": "http://18.220.231.8:8080/AppSolsticeDemo/services/contact/35"
        },
        {
            "type": "application/json",
            "method": "PUT",
            "rel": "modify",
            "href": "http://18.220.231.8:8080/AppSolsticeDemo/services/contact/35"
        }
    ]
}
```
#### h. Update a contact record (/{contactId})
##### Description: 
This method allows us to update the corresponding values of a Contact
##### URI: 
http://18.220.231.8:8080/AppSolsticeDemo/services/contact/35
##### Parameters
**-contactId:** variable of type Long, referencing the contactId of the Contact to be updated
##### Method: 
PUT 
##### Headers:   
```
Accept:application/json  
Content-Type:application/json  
```
##### Body: 
Object of ContactRequest type.

```
{
	"name": "Clark Kent",
    "company": "Planet",
    "profileImage": "",
    "email": "clark.kent@gmail.com",
    "birthdate": "01/01/1990",
    "personalPhoneNumber": "312-333-5555",
    "workPhoneNumber": "312-333-5554",
    "address": {
        "street": "Michigan Ave",
        "unit": "34",
        "city": "New York",
        "state": "NY",
        "zip": "60200"
    }
}
```
##### Response:  
```
Ok: 200
```
#### i. Delete a contact record (/{contactId})
##### Description: 
This method allows us to delete a Contact
##### URI: 
http://18.220.231.8:8080/AppSolsticeDemo/services/contact/35
##### Parameters
**contactId:** variable of type Long, referencing the contactId of the Contact to be deleted
##### Method: 
DELETE 
##### Headers:   
```
Accept:application/json   
```
##### Body: 
```
none
```
##### Response:  
```
Ok: 200
```
## JUnit Test Cases
### com.solstice.contact.web.resource.test.ContactResourceImplTest.java
```
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
```