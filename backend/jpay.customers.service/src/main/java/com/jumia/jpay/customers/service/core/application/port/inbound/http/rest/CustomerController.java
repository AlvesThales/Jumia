package com.jumia.jpay.customers.service.core.application.port.inbound.http.rest;

import com.jumia.jpay.customers.service.core.application.service.customer.CustomerDto;
import com.jumia.jpay.customers.service.core.application.service.customer.PhoneDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public interface CustomerController {

    @GetMapping
    ResponseEntity<List<CustomerDto>> getAll();

    @GetMapping("/phones")
    ResponseEntity<List<PhoneDto>> getCustomersPhones();


}
