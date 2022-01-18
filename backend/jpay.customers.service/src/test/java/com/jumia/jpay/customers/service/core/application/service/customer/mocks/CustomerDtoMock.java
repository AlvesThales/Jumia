package com.jumia.jpay.customers.service.core.application.service.customer.mocks;

import com.jumia.jpay.customers.service.core.application.service.customer.CustomerDto;

public class CustomerDtoMock {

    public static CustomerDto create() {
        var customerDto = new CustomerDto();

        customerDto.setId(123);
        customerDto.setName("Jane Doe");
        customerDto.setPhone("(256) 714660221");

        return customerDto;
    }
}
