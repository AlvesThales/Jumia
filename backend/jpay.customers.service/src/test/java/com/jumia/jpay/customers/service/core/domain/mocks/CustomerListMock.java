package com.jumia.jpay.customers.service.core.domain.mocks;

import com.jumia.jpay.customers.service.core.domain.Customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerListMock {

    public static List<Customer> create() {
        List<Customer> customers = new ArrayList<>();
        customers.add(CustomerMock.create());
        customers.add(CustomerMock.create());
        customers.add(CustomerMock.create());

        return customers;
    }
}
