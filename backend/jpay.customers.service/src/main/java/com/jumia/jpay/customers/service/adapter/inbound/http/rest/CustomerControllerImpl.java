package com.jumia.jpay.customers.service.adapter.inbound.http.rest;

import com.jumia.jpay.customers.service.core.application.port.inbound.http.rest.CustomerController;
import com.jumia.jpay.customers.service.core.application.service.customer.CustomerDto;
import com.jumia.jpay.customers.service.core.application.service.customer.CustomerService;
import com.jumia.jpay.customers.service.core.application.service.customer.PhoneDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerControllerImpl implements CustomerController {

    private CustomerService customerService;

    @Autowired
    public CustomerControllerImpl(CustomerService customerService) {
        this.customerService = customerService;
    }

    @Override
    public ResponseEntity<List<CustomerDto>> getAll() {

        var customers = customerService.getAll();
        if (customers == null || customers.isEmpty()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return ResponseEntity.ok(customers);
    }

    @Override
    public ResponseEntity<List<PhoneDto>> getCustomersPhones() {

        var customers = customerService.getAll();
        if (customers == null || customers.isEmpty()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        return ResponseEntity.ok(customerService.getCustomersPhones(customers));
    }
}