package com.solstice.contact.web.requests;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "Contact")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
public class ContactRequest {
	private String name;
	private String company;
	private String profileImage;
	private String email;
	private String birthdate;
	private String personalPhoneNumber;
	private String workPhoneNumber;
	private AddressRequest address;

	public ContactRequest() {
	}

	public ContactRequest(String name, String company, String profileImage, String email, String birthdate,
			String personalPhoneNumber, String workPhoneNumber, AddressRequest address) {
		this.name = name;
		this.company = company;
		this.profileImage = profileImage;
		this.email = email;
		this.birthdate = birthdate;
		this.personalPhoneNumber = personalPhoneNumber;
		this.workPhoneNumber = workPhoneNumber;
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getProfileImage() {
		return profileImage;
	}

	public void setProfileImage(String profileImage) {
		this.profileImage = profileImage;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}

	public String getPersonalPhoneNumber() {
		return personalPhoneNumber;
	}

	public void setPersonalPhoneNumber(String personalPhoneNumber) {
		this.personalPhoneNumber = personalPhoneNumber;
	}

	public String getWorkPhoneNumber() {
		return workPhoneNumber;
	}

	public void setWorkPhoneNumber(String workPhoneNumber) {
		this.workPhoneNumber = workPhoneNumber;
	}

	public AddressRequest getAddress() {
		return address;
	}

	public void setAddress(AddressRequest address) {
		this.address = address;
	}

}
