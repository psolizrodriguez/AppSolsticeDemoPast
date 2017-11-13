package com.solstice.contact.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.solstice.common.model.Address;
import com.solstice.contact.dao.AddressDao;
import com.solstice.contact.service.AddressService;

@Service
public class AddressServiceImpl implements AddressService {
	@Autowired
	AddressDao dao;

	@Override
	public Address save(Address address) {
		return dao.save(address);
	}

	@Override
	public List<Address> listAll() {
		return dao.listAll();
	}

	@Override
	public Address getById(Long addressId) {
		return dao.getById(addressId);
	}

	@Override
	public boolean remove(Address address) {
		return dao.remove(address);
	}

}
