package com.solstice.contact.service;

import java.util.List;

import com.solstice.common.model.Address;

public interface AddressService {
	public Address save(Address address);

	public List<Address> listAll();

	public Address getById(Long addressId);

	public boolean remove(Address address);
}
