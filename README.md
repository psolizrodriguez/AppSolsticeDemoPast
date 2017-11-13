# Backend Coding Challenge for Solstice  

## Position  
[Senior Java/Spring Developer](https://stackoverflow.com/jobs/158140/senior-java-spring-developer-solstice)  

## Applicant 
[Percy Soliz](https://www.linkedin.com/in/psolizrodriguez/)  

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

## Entity Relationship Diagram  

## Endpoints 
### 1. com.solstice.contact.web.resource.impl.ContactResourceImpl.java (/contact)
#### a. List all contacts
##### Description: 
This method returns all the records of the Contact table
##### URI: 
http://18.220.231.8:8080/AppSolsticeDemo/services/contact 
##### Parameters
None 
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
#### b. List all contacts by Email  (/email/{email})
##### Description: 
This method returns all the records of the Contact table with matching email
##### URI: 
http://18.220.231.8:8080/AppSolsticeDemo/services/contact/email/jane.doe 
##### Parameters
**email:** string to search on database
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
#### c. List all contacts by Phone Number  (/phoneNumber/{phoneNumber})
##### Description: 
This method returns all the records of the Contact table with matching personal or work phone number
##### URI: 
http://18.220.231.8:8080/AppSolsticeDemo/services/contact/phoneNumber/312-333-4444 
##### Parameters
**phoneNumber:** string to search on database
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