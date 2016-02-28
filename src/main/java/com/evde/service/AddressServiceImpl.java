package com.evde.service;

import com.evde.dao.IAddressDAO;
import com.sun.org.apache.bcel.internal.generic.IADD;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

/**
 * Created by mesut on 28.02.2016.
 */
public class AddressServiceImpl implements IAddress {

    @Autowired
    IAddressDAO address;
    public List<Map<String, Object>> listAddress() {
        return address.addressList();
    }
}
