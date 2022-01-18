package com.jumia.jpay.customers.service.core.application.service.customer;

import com.jumia.jpay.customers.service.core.application.port.outbound.database.sqlite.CustomerRepository;
import com.jumia.jpay.customers.service.core.application.service.customer.mocks.CustomerDtoListMock;
import com.jumia.jpay.customers.service.core.domain.mocks.CustomerListMock;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CustomerServiceImplTest {

    @Mock
    CustomerRepository repository;

    @InjectMocks
    CustomerServiceImpl customerService;

    @Test
    void shouldGetAllCustomersFromRepository() {

        when(repository.findAll()).thenReturn(CustomerListMock.create());

        var customers = customerService.getAll();

        assertNotNull(customers);
        assertEquals(3, customers.size());
    }

    @Test
    void shouldGetCustomersPhonesFromAListOfCustomers() {

        var customers = CustomerDtoListMock.create();

        var phones = customerService.getCustomersPhones(customers);

        assertNotNull(phones);
        assertEquals(3, phones.size());
    }
}