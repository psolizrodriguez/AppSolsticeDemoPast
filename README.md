# Backend Coding Challenge for Solstice  

## Position  
[Senior Java/Spring Developer](https://stackoverflow.com/jobs/158140/senior-java-spring-developer-solstice)  

## Applicant 
[Percy Soliz](https://www.linkedin.com/in/psolizrodriguez/)  

## Purpose
As part of Solstice�s hiring process, we ask interviewees to complete a small project to help assess skill, experience, ingenuity, problem-solving and knowledge.  

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
This method performs a search over the title column of product table joining it with inventory and verifying the quantity is bigger than 0  
##### URI: 
http://18.220.231.8:8080/AppSolsticeDemo/services/services/contact 
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
        "contactId": 1,
        "name": "Percy Soliz",
        "company": "Solstice",
        "profileImage": null,
        "email": "percy.soliz.rodriguez@gmail.com",
        "birthdate": "02/01/1988",
        "personalPhoneNumber": "312-383-8870",
        "workPhoneNumber": null,
        "address": {
            "addressId": 1,
            "street": "1068 W Granville Ave",
            "unit": "22",
            "city": "Chicago",
            "state": "IL",
            "zip": "60660"
        }
    }
]
```
