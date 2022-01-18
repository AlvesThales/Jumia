package com.jumia.jpay.customers.service.core.domain.mocks;

import com.jumia.jpay.customers.service.core.domain.Customer;

public class CustomerMock {

    public static Customer create() {
        var customer = new Customer();
        customer.setId(1);
        customer.setName("John Doe");
        customer.setPhone("(212) 698054873");

        return customer;
    }
}
