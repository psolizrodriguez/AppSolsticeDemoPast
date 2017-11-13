package com.solstice.contact.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.solstice.common.dao.AbstractBaseDao;
import com.solstice.common.model.Address;
import com.solstice.contact.dao.AddressDao;

@SuppressWarnings("rawtypes")
@Repository
public class AddressDaoImpl extends AbstractBaseDao implements AddressDao {

	@SuppressWarnings("unchecked")
	@Transactional
	public Address save(Address address) {
		return (Address) super.store(address);
	}

	public List<Address> listAll() {
		return super.verifyListNamedQueryAll("com.solstice.contact.dao.impl.AddressDaoImpl.listAll");
	}

	@Transactional
	public boolean remove(Address address) {
		return super.remove(address);

	}

	@Override
	public Address getById(Long addressId) {
		return super.verifyNamedQueryAll("com.solstice.contact.dao.impl.AddressDaoImpl.getById", addressId);
	}
}