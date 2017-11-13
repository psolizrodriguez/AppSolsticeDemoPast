package com.solstice.contact.web.representations;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.solstice.common.constants.AppBaseConstantsWeb;
import com.solstice.common.model.Contact;
import com.solstice.common.utility.AbstractRepresentation;
import com.solstice.common.utility.AppBaseUtilsWeb;

@XmlRootElement(name = "Contact")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
public class ContactRepresentation extends AbstractRepresentation {
	private Long contactId;
	private String name;
	private String company;
	private String profileImage;
	private String email;
	private String birthdate;
	private String personalPhoneNumber;
	private String workPhoneNumber;
	private AddressRepresentation address;

	public ContactRepresentation() {
	}

	public ContactRepresentation(Long contactId, String name, String company, String profileImage, String email,
			String birthdate, String personalPhoneNumber, String workPhoneNumber, AddressRepresentation address) {
		this.contactId = contactId;
		this.name = name;
		this.company = company;
		this.profileImage = profileImage;
		this.email = email;
		this.birthdate = birthdate;
		this.personalPhoneNumber = personalPhoneNumber;
		this.workPhoneNumber = workPhoneNumber;
		this.address = address;
	}

	public ContactRepresentation(Contact contact) {
		this.contactId = contact.getContactId();
		this.name = contact.getName();
		this.company = contact.getCompany();
		this.profileImage = contact.getProfileImage();
		this.email = contact.getEmail();
		this.birthdate = AppBaseUtilsWeb.CalendarToString(contact.getBirthdate(), AppBaseConstantsWeb.DATE_FORMAT);
		this.personalPhoneNumber = contact.getPersonalPhoneNumber();
		this.workPhoneNumber = contact.getWorkPhoneNumber();
		this.address = new AddressRepresentation(contact.getAddress());
	}

	public Long getContactId() {
		return contactId;
	}

	public void setContactId(Long contactId) {
		this.contactId = contactId;
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

	public AddressRepresentation getAddress() {
		return address;
	}

	public void setAddress(AddressRepresentation address) {
		this.address = address;
	}

}
