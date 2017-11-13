package com.solstice.contact.dao;

import java.util.List;

import com.solstice.common.dao.Dao;
import com.solstice.common.model.Address;

public interface AddressDao extends Dao {
	public Address save(Address address);

	public List<Address> listAll();

	public Address getById(Long addressId);

	public boolean remove(Address address);
}
