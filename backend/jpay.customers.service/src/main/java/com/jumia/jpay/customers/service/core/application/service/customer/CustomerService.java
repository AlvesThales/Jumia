package com.jumia.jpay.customers.service.core.application.service.customer;

import java.util.List;

public interface CustomerService {

    List<CustomerDto> getAll();

    List<PhoneDto> getCustomersPhones(List<CustomerDto> customers);
}
