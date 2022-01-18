package com.jumia.jpay.customers.service.core.application.service.customer;

import com.jumia.jpay.customers.service.core.application.port.outbound.database.sqlite.CustomerRepository;
import com.jumia.jpay.customers.service.core.domain.Customer;
import com.jumia.jpay.customers.service.core.domain.Phone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.jumia.jpay.customers.service.core.domain.Phone.toPhoneDto;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    private CustomerDto toCustomerDto(Customer customer) {
        return new CustomerDto(customer.getId(), customer.getName(), customer.getPhone());
    }

    public List<CustomerDto> getAll() {

        var customers = customerRepository.findAll();
        if (customers.isEmpty()) return null;

        List<CustomerDto> customersDto = new ArrayList<>();
        for (Customer c : customers) {
            customersDto.add(toCustomerDto(c));
        }
        return customersDto;
    }

    public List<PhoneDto> getCustomersPhones(List<CustomerDto> customers) {
        List<PhoneDto> phones = new ArrayList<>();
        for (CustomerDto c : customers) {
            phones.add(toPhoneDto(Phone.create(c.getPhone())));
        }
        return phones;
    }
}
