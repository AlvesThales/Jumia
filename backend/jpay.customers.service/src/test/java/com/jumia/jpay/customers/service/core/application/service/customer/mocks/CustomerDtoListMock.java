package com.jumia.jpay.customers.service.core.application.service.customer.mocks;

import com.jumia.jpay.customers.service.core.application.service.customer.CustomerDto;

import java.util.ArrayList;
import java.util.List;

public class CustomerDtoListMock {

    public static List<CustomerDto> create() {
        List<CustomerDto> customersDto = new ArrayList<>();
        customersDto.add(CustomerDtoMock.create());
        customersDto.add(CustomerDtoMock.create());
        customersDto.add(CustomerDtoMock.create());

        return customersDto;
    }
}
