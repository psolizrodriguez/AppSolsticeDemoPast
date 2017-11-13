package com.solstice.contact.web.requests;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "Address")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
public class AddressRequest {
	private String street;
	private String unit;
	private String city;
	private String state;
	private String zip;

	public AddressRequest(String street, String unit, String city, String state, String zip) {
		this.street = street;
		this.unit = unit;
		this.city = city;
		this.state = state;
		this.zip = zip;
	}

	public AddressRequest() {
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

}
